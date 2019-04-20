package cn.ljlin233.user.dao;

/**
 * UserTokenDao
 */
public interface UserTokenDao {

    void addToken(String userId, String token);

    String getToken(String userId);

    void deleteToken(String userId);

    void refreshToken(String userId);

    long getTokenTime(String userId);

    boolean hasTokenKey(String userId);

}