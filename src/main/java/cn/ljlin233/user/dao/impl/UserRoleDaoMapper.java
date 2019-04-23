package cn.ljlin233.user.dao.impl;


import cn.ljlin233.user.dao.UserRoleDao;

/**
 * UserRoleDaoMapper
 */
public interface UserRoleDaoMapper extends UserRoleDao {

    @Override
    public void addUserRole(int user_id, String role);
    
    @Override
    public void deleteUserRole();

}