package cn.ljlin233.user.dao;

import java.util.List;
import cn.ljlin233.user.entity.UserInfo;

/**
 * UserInfoDao
 */
public interface UserInfoDao {

    public void addUserInfo(String account, String email, String registerTime, String activeId);

    public void deleteUserInfo(int id);

    public void updateUserInfo(UserInfo userInfo);

    public List<UserInfo> getAllUserInfo();

    public UserInfo getUserInfoById(int id);
    
    public int getUserIdByAccount(String account);

    public int getUserIdByActiveId(String activeId);

    public int existsAccount(String account);

    public int existsEmail(String email);

    public int existsPhone(String phone);

    public int isActive(String account);

    public void updateUsername(String tableName, String nameCol, String newName, String idCol, int userId);
}