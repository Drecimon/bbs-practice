package cn.ljlin233.user.dao;

/**
 * UserAuthsDao
 */
public interface UserAuthsDao {

    void addUserAuths(int user_id, String identity_type, String identifier, String credential);

    void deleteAuths();

}