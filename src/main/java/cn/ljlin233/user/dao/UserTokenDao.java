package cn.ljlin233.user.dao;

/**
 * UserTokenDao
 */
public interface UserTokenDao {

    void addToken(String token, String userId);

    String getUserId(String token);

    void deleteToken(String token);

    void refreshToken(String token);

    long getTokenTime(String token);

    boolean hasToken(String token);

}