package cn.ljlin233.user.dao;

import java.util.List;

/**
 * UserRoleDao
 */
public interface UserRoleDao {

    void addUserRole(int userId, String role);
    
    void deleteUserRole(int userId);

    List<String> getUserRoleByUserId(int userId);

}