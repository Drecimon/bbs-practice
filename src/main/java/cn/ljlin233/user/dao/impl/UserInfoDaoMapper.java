package cn.ljlin233.user.dao.impl;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import cn.ljlin233.user.dao.UserInfoDao;
import cn.ljlin233.user.entity.UserInfo;

/**
 * UserInfoDaoMapper
 */
public interface UserInfoDaoMapper extends UserInfoDao {

    @Override
    public void addUser();

    @Override
    public void deleteUser();

    @Override
    public void modifyUser();

    @Override
    public ArrayList<UserInfo> getAllUserInfo();

    @Override
    @Select("select * from user_info where id = #{id}")
    public UserInfo getUserInfoById(int id);
    
}