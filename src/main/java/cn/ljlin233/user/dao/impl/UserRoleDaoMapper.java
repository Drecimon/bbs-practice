package cn.ljlin233.user.dao.impl;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.ljlin233.user.dao.UserRoleDao;

/**
 * UserRoleDaoMapper
 */
public interface UserRoleDaoMapper extends UserRoleDao {

    @Override
    @Insert("insert into user_role (user_id, role) values (#{userId}, #{role})")
    public void addUserRole(@Param("userId") int userId, @Param("role") String role);
    
    @Override
    @Delete("delete from user_role where user_id = #{userId}")
    public void deleteUserRole(int userId);

}