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
    public void addToken(String token, String userId) {

        stringRedisTemplate.opsForValue().set(token, userId , 24*7, TimeUnit.HOURS);

    }

    @Override
    public String getUserId(String token) {
        String result = "";
        boolean keyFlag = stringRedisTemplate.hasKey(token);
        if (keyFlag) {
            result = stringRedisTemplate.opsForValue().get(token);
        }
        return result;
    }

    @Override
    public void deleteToken(String token) {
        stringRedisTemplate.delete(token);
    }

    @Override
    public void refreshToken(String token) {
        stringRedisTemplate.expire(token, 24*7, TimeUnit.HOURS);
    }

    @Override
    public long getTokenTime(String token) {

        return stringRedisTemplate.getExpire(token, TimeUnit.SECONDS);
    }

    @Override
    public boolean hasToken(String token) {
        return stringRedisTemplate.hasKey(token);
    }

}