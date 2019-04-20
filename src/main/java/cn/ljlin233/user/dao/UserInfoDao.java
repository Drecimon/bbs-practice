package cn.ljlin233.user.dao;

import java.util.List;
import cn.ljlin233.user.entity.UserInfo;

/**
 * UserInfoDao
 */
public interface UserInfoDao {

    public void addUser();
    public void deleteUser();
    public void modifyUser();
    public List<UserInfo> getAllUserInfo();
    public UserInfo getUserInfoById(int id);
}