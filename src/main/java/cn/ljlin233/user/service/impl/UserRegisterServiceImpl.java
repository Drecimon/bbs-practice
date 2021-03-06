package cn.ljlin233.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import cn.ljlin233.config.MailConfig;
import cn.ljlin233.user.dao.UserAuthsDao;
import cn.ljlin233.user.dao.UserInfoDao;
import cn.ljlin233.user.dao.UserOriginDao;
import cn.ljlin233.user.dao.UserRoleDao;
import cn.ljlin233.user.service.UserRegisterService;
import cn.ljlin233.util.email.entity.ActiveEmail;
import cn.ljlin233.util.email.service.ActiveEmailService;
import cn.ljlin233.util.exception.entity.DataCheckedException;
import cn.ljlin233.util.exception.entity.SystemException;
import cn.ljlin233.util.verification.service.VerificationService;

/**
 * UserRegisterServiceImpl
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    private UserInfoDao userInfoDao;
    private UserAuthsDao userAuthsDao;
    private UserRoleDao userRoleDao;
    private UserOriginDao userOriginDao;
    private VerificationService verificationService;
    private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private ActiveEmailService activeEmailService;

    public UserRegisterServiceImpl () {}


    @Autowired
    public UserRegisterServiceImpl (UserInfoDao userInfoDao, UserAuthsDao userAuthsDao, UserRoleDao userRoleDao, 
        UserOriginDao userOriginDao, VerificationService verificationService, ActiveEmailService activeEmailService) {

        this.userInfoDao = userInfoDao;
        this.userAuthsDao = userAuthsDao;
        this.userRoleDao = userRoleDao;
        this.userOriginDao = userOriginDao;
        this.verificationService = verificationService;
        this.activeEmailService = activeEmailService;
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void registerUser(String account, String password, String role, String email, 
        String VerificationId, String VerificationCode) {
        
        if (account == null || account.length()>10) {
            throw new DataCheckedException("账号为空或过长");
        }
        if (password == null || password.length()>10) {
            throw new DataCheckedException("密码为空或过长");
        }        
        if (role == null || !(role.equals("student") || role.equals("teacher")) ) {
            throw new DataCheckedException("角色非法");
        }
        if (email == null || !checkEmailFormat(email)) {
            throw new DataCheckedException("邮箱格式错误");
        }
        // 检查验证码
        if (!verificationService.checkVerification(VerificationId, VerificationCode)) {
            throw new DataCheckedException("验证码错误");
        }

        // 检查注册账号是否在起源表
        if (userOriginDao.existsAccount(account) == 0) {
            throw new DataCheckedException("此账号未在原始名单");
        }

        // 检查账号是否已注册
        if (userInfoDao.existsAccount(account) == 1) {
            // 当账号已激活
            if (userInfoDao.isActive(account) == 1) {
                throw new DataCheckedException("此账号已注册");
            } else {
                // 当账户未激活
                try {
                    int userId = userInfoDao.getUserIdByAccount(account);
                    userInfoDao.deleteUserInfo(userId);
                    userAuthsDao.deleteAuths(userId);
                    userRoleDao.deleteUserRole(userId);
                } catch (Exception e) {
                    SystemException ex = new SystemException();
                    ex.setFriendMessage("数据库删除未激活用户失败");
                    ex.setMessage(e.getMessage());
                    throw ex;
                }
            }
        } 

        // 检查邮箱是否已注册
        if (userInfoDao.existsEmail(email) == 1) {
            throw new DataCheckedException("此邮箱已注册");
        }

        // 时间格式转化
        Date date = new Date();
        String registerTime = dateformat.format(date);
        // 密码MD5加密
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        // 激活码
        String activeId = UUID.randomUUID().toString().replace("-", "");

        // 数据库存储
        try {
            userInfoDao.addUserInfo(account, email, registerTime, activeId);
            int user_id = userInfoDao.getUserIdByAccount(account);
            userAuthsDao.addUserAuths(user_id, "account", account, md5Password);
            userAuthsDao.addUserAuths(user_id, "email", email, md5Password);
            userRoleDao.addUserRole(user_id, role);            
        } catch (Exception e) {
            SystemException ex = new SystemException();
            ex.setFriendMessage("数据库添加用户失败");
            ex.setMessage(e.getMessage());
            throw ex;
        }

        // 发送激活邮件
        
        ActiveEmail activeEmail = new ActiveEmail();
        activeEmail.setSendFrom(MailConfig.username);
        activeEmail.setSendTo(email);
        activeEmail.setTitle("实验室账号激活链接");
        activeEmail.setMessage("127.0.0.1/lab/user?activeId=" + activeId);
        try {
            activeEmailService.sendActiveEamil(activeEmail);
        } catch (Exception e) {
            SystemException ex = new SystemException();
            ex.setFriendMessage("激活邮件发送失败，重新注册");
            ex.setMessage(e.getMessage());
            throw ex;
        }
    }


    private boolean checkEmailFormat(String email) {
        int index2 = email.lastIndexOf("@");

        // 获取邮箱中"."号的位置
        int index3 = email.indexOf('.');

        // 判断必须包含"@"符号，且"@"必须在"."之前
        if (index2 != -1 && index3 > index2) {
            return true;
        } else {
            return false;
        }
    }
    
}