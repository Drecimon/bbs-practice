package cn.ljlin233.user.dao;

/**
 * UserAuthsDao
 */
public interface UserAuthsDao {

    
    void addUserAuths(int userId, String identityType, String identifier, String credential);

    void deleteAuths();

}