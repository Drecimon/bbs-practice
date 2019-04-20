package cn.ljlin233.user.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ljlin233.user.dao.UserTokenDao;
import cn.ljlin233.user.service.UserTokenService;

/**
 * UserTokenServiceImpl
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    private UserTokenDao userTokenDao;

    public UserTokenServiceImpl() {}

    @Autowired
    public UserTokenServiceImpl(UserTokenDao userTokenDao) {
        this.userTokenDao = userTokenDao;
    }


    @Override
    public void addToken(String userId) {
        String token = UUID.randomUUID().toString().replace("-", "");
        userTokenDao.addToken(userId, token);
    }

    @Override
    public void deleteToken(String userId) {
        userTokenDao.deleteToken(userId);
    }

    @Override
    public boolean checkRefreshToken(String userId, String token) {

        boolean result = false;
        boolean keyFlag = userTokenDao.hasTokenKey(userId);
        if (keyFlag) {
            if (userTokenDao.getToken(userId).compareTo(token) == 0) {
                result = true;
                userTokenDao.refreshToken(userId);
            } 
        }
        return result;
    }

}