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
    public String addToken(int userId) {
        String token = UUID.randomUUID().toString().replace("-", "");
        userTokenDao.addToken(String.valueOf(userId), token);
        return token;
    }

    @Override
    public void deleteToken(int userId) {
        userTokenDao.deleteToken(String.valueOf(userId));
    }

    @Override
    public boolean checkRefreshToken(int userId, String token) {

        boolean result = false;
        String userIdString = String.valueOf(userId);
        boolean keyFlag = userTokenDao.hasTokenKey(userIdString);
        if (keyFlag) {
            if (userTokenDao.getToken(userIdString).compareTo(token) == 0) {
                result = true;
                userTokenDao.refreshToken(userIdString);
            }
        }
        return result;
    }

}