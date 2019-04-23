package cn.ljlin233.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ljlin233.user.dao.UserAuthsDao;
import cn.ljlin233.user.dao.UserInfoDao;
import cn.ljlin233.user.dao.UserOriginDao;
import cn.ljlin233.user.dao.UserRoleDao;
import cn.ljlin233.user.service.UserRegisterService;
import cn.ljlin233.util.exception.entity.DataCheckedException;
import cn.ljlin233.util.exception.entity.VerificationErrorException;
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

    public UserRegisterServiceImpl () {}


    @Autowired
    public UserRegisterServiceImpl (UserInfoDao userInfoDao, UserAuthsDao userAuthsDao, 
        UserRoleDao userRoleDao, UserOriginDao userOriginDao , VerificationService verificationService) {

        this.userInfoDao = userInfoDao;
        this.userAuthsDao = userAuthsDao;
        this.userRoleDao = userRoleDao;
        this.userOriginDao = userOriginDao;
        this.verificationService = verificationService;
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
            throw new VerificationErrorException();
        }

        // 检查注册账号是否在起源表
        if (userOriginDao.existsAccount(account) == 0) {
            throw new DataCheckedException("此账号未在原始名单");
        }

        // 检查账号是否已注册
        if (userInfoDao.existsAccount(account) == 1) {
            throw new DataCheckedException("此账号已注册");
        }

        // 检查邮箱是否已注册
        if (userInfoDao.existsEmail(email) == 1) {
            throw new DataCheckedException("此邮箱已注册");
        }


        // 时间格式转化
        Date date = new Date();
        String register_time = dateformat.format(date);
        // 密码MD5加密

        // 数据库存储
        userInfoDao.addUserInfo(account, email, register_time);
        int user_id = userInfoDao.getUserIdByAccount(account);
        userAuthsDao.addUserAuths(user_id, "account", account, password);
        userAuthsDao.addUserAuths(user_id, "email", email, password);
        userRoleDao.addUserRole(user_id, role);


        // 邮件服务

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