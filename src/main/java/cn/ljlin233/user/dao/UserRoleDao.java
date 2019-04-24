package cn.ljlin233.user.dao;

/**
 * UserRoleDao
 */
public interface UserRoleDao {

    void addUserRole(int userId, String role);
    
    void deleteUserRole(int userId);

}