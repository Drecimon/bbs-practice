package cn.ljlin233.user.dao.impl;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.ljlin233.user.dao.UserAuthsDao;

/**
 * UserAuthsDaoMapper
 */
public interface UserAuthsDaoMapper extends UserAuthsDao {


    @Override
    public void deleteAuths();


    @Override
    @Insert("insert into user_auths (user_id, identity_type, identifier, credential) values ( #{userId}, #{identityType}, #{identifier}, #{credential})")
    public void addUserAuths(@Param("userId") int userId, @Param("identityType") String identityType, @Param("identifier") String identifier,@Param("credential") String credential);
    
}