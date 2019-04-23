package cn.ljlin233.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ljlin233.user.dao.UserInfoDao;
import cn.ljlin233.user.entity.UserInfo;
import cn.ljlin233.user.service.UserInfoService;

/**
 * UserInfoServiceImpl
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfo userInfo;
    private UserInfoDao userInfoDao;
    
    public UserInfoServiceImpl() {};

    @Autowired
    public UserInfoServiceImpl(UserInfo userInfo, UserInfoDao userInfoDao) {
        
        this.userInfo = userInfo;
        this.userInfoDao = userInfoDao;
    }

    @Override
    public UserInfo getUserInfo(int id) {
        userInfo = userInfoDao.getUserInfoById(id);
        return userInfo;
    }

    @Override
    public boolean existsAccount() {
        return false;
    }

    @Override
    public boolean existsEmail() {
        return false;
    }

}