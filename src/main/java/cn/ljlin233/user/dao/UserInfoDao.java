package cn.ljlin233.user.dao;

import java.util.Date;
import java.util.List;
import cn.ljlin233.user.entity.UserInfo;

/**
 * UserInfoDao
 */
public interface UserInfoDao {

    public void addUserInfo(String account, String email, String phone, String nickname, String introduce,
        Date register_time, String profile_picture);

    public void deleteUserInfo();

    public void modifyUserInfo();

    public List<UserInfo> getAllUserInfo();

    public UserInfo getUserInfoById(int id);
    
    public int getUserIdByAccount(String account);
}