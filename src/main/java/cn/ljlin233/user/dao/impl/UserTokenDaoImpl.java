package cn.ljlin233.user.dao.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import cn.ljlin233.user.dao.UserTokenDao;

/**
 * UserTokenDaoImpl
 */
@Repository
public class UserTokenDaoImpl implements UserTokenDao {


    private StringRedisTemplate stringRedisTemplate;

    private UserTokenDaoImpl() {};

    @Autowired
    private UserTokenDaoImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    @Override
    public void addToken(String userId, String token) {

        stringRedisTemplate.opsForValue().set(userId, token , 24*7, TimeUnit.HOURS);

    }

    @Override
    public String getToken(String userId) {
        String result = "";
        boolean keyFlag = stringRedisTemplate.hasKey(userId);
        if (keyFlag) {
            result = stringRedisTemplate.opsForValue().get("userId");
        }
        return result;
    }

    @Override
    public void deleteToken(String userId) {
        stringRedisTemplate.delete(userId);
    }

    @Override
    public void refreshToken(String userId) {
        stringRedisTemplate.expire(userId, 24*7, TimeUnit.HOURS);
    }

    @Override
    public long getTokenTime(String userId) {

        return stringRedisTemplate.getExpire(userId, TimeUnit.SECONDS);
    }

    @Override
    public boolean hasTokenKey(String userId) {
        return stringRedisTemplate.hasKey(userId);
    }

}