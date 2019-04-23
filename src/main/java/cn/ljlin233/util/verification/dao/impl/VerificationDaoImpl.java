package cn.ljlin233.util.verification.dao.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import cn.ljlin233.util.verification.dao.VerificationDao;

/**
 * VerificationDaoImpl
 */
@Repository
public class VerificationDaoImpl implements VerificationDao {

    private StringRedisTemplate stringRedisTemplate;

    private VerificationDaoImpl() {};

    @Autowired
    private VerificationDaoImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void addVerification(String verId, String verCode) {
        stringRedisTemplate.opsForValue().set(verId, verCode, 2, TimeUnit.MINUTES);
    }

    @Override
    public String getVerificationCode(String verId) {
        return stringRedisTemplate.opsForValue().get(verId);
    }

}