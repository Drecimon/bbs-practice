package cn.ljlin233.user.dao.impl;

import org.apache.ibatis.annotations.Select;

import cn.ljlin233.user.dao.UserOriginDao;

/**
 * UserOriginDaoMapper
 */
public interface UserOriginDaoMapper extends UserOriginDao {

    @Override
    public void addUserOrigin(String account);

    @Override
    public void deleteUserOrigin(String account);

    @Override
    @Select("select id from user_origin where account = #{account}")
    public int getUserOriginId(String account);

    
}