package cn.ljlin233.user.service;

/**
 * UserTokenService
 */
public interface UserTokenService {

    String addToken(int userId);

    void deleteToken(int userId);

    boolean checkRefreshToken(int userId, String token);

}