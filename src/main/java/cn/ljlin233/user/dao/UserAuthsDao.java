package cn.ljlin233.user.dao;

import cn.ljlin233.user.entity.UserAuths;

/**
 * UserAuthsDao
 */
public interface UserAuthsDao {

    
    void addUserAuths(int userId, String identityType, String identifier, String credential);

    void deleteAuths(int userId);

    UserAuths getUserAuthsByidentifier(String identifier);

}