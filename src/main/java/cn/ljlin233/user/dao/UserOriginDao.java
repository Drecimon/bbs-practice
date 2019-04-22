package cn.ljlin233.user.dao;

/**
 * UserOriginDao
 */
public interface UserOriginDao {

    
    void addUserOrigin(String account);

    void deleteUserOrigin(String account);

    int getUserOriginId(String account);

}