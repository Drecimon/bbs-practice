package cn.ljlin233.user.dao;

/**
 * UserOriginDao
 */
public interface UserOriginDao {

    
    void addUserOrigin(String account);

    void deleteUserOrigin(String account);

    Integer getUserOriginId(String account);

    public int existsAccount(String account);
}