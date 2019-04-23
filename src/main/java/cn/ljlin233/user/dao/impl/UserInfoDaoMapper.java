package cn.ljlin233.user.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.ljlin233.user.dao.UserInfoDao;
import cn.ljlin233.user.entity.UserInfo;

/**
 * UserInfoDaoMapper
 */
public interface UserInfoDaoMapper extends UserInfoDao {

    @Override
    @Insert("insert into user_info (account, email, register_time) values (#{account}, #{email}, #{registerTime})")
    public void addUserInfo(@Param("account") String account, @Param("email") String email, @Param("registerTime") String registerTime);
        

    @Override
    public void deleteUserInfo();


    @Override
    public void modifyUserInfo();


    @Override
    public List<UserInfo> getAllUserInfo();


    @Override
    @Select("select * from user_info where id = #{id}")
    @Results({
        @Result(column = "register_time", property = "registerTime"),
        @Result(column = "profile_picture", property = "profilePicture"), 
    })
    public UserInfo getUserInfoById(int id);
    

    @Override
    @Select("select id from user_info where account = #{account}")
    public int getUserIdByAccount(String account);


    @Override
    @Select("select count(1) from user_info where account = #{account}")
    public int existsAccount(String account);


    @Override
    @Select("select count(1) from user_info where email = #{email}")
    public int existsEmail(String email);


    @Override
    @Select("select count(1) from user_info where phone = #{phone}")
    public int existsPhone(String phone);

}