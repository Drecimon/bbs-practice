package cn.ljlin233.user.dao;

/**
 * UserRoleDao
 */
public interface UserRoleDao {

    void addUserRole(int user_id, String role);
    
    void deleteUserRole();

}