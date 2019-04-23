package cn.ljlin233.user.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ljlin233.user.dao.UserAuthsDao;
import cn.ljlin233.user.dao.UserInfoDao;
import cn.ljlin233.user.dao.UserRoleDao;
import cn.ljlin233.user.service.UserRegisterService;
import cn.ljlin233.util.verification.service.VerificationService;

/**
 * UserRegisterServiceImpl
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    private UserInfoDao userInfoDao;
    private UserAuthsDao userAuthsDao;
    private UserRoleDao userRoleDao;
    private VerificationService verificationService;

    public UserRegisterServiceImpl () {}


    @Autowired
    public UserRegisterServiceImpl (UserInfoDao userInfoDao, UserAuthsDao userAuthsDao, 
        UserRoleDao userRoleDao, VerificationService verificationService) {

        this.userInfoDao = userInfoDao;
        this.userAuthsDao = userAuthsDao;
        this.userRoleDao = userRoleDao;
        this.verificationService = verificationService;
    }


    @Override
    public void registerUser(String account, String password, String role, String email, 
        String VerificationId, String VerificationCode) {

        if (!verificationService.checkVerification(VerificationId, VerificationCode)) {
            return;
        }

        try {
            Date register_time = new Date();

            userInfoDao.addUserInfo(account, email, null, null, null, register_time, null);

            int user_id = userInfoDao.getUserIdByAccount(account);
            userAuthsDao.addUserAuths(user_id, "account", account, password);
            userAuthsDao.addUserAuths(user_id, "email", email, password);
            userRoleDao.addUserRole(user_id, role);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
}