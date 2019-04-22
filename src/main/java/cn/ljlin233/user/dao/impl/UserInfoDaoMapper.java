package cn.ljlin233.user.dao.impl;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Select;

import cn.ljlin233.user.dao.UserInfoDao;
import cn.ljlin233.user.entity.UserInfo;

/**
 * UserInfoDaoMapper
 */
public interface UserInfoDaoMapper extends UserInfoDao {

    @Override
    public void addUserInfo(String account, String email, String phone, String nickname, String introduce,
        Date register_time, String profile_picture);
        

    @Override
    public void deleteUserInfo();

    @Override
    public void modifyUserInfo();

    @Override
    public ArrayList<UserInfo> getAllUserInfo();

    @Override
    @Select("select * from user_info where id = #{id}")
    public UserInfo getUserInfoById(int id);
    
}