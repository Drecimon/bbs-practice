package cn.ljlin233.user.service;

/**
 * UserTokenService
 */
public interface UserTokenService {

    void addToken(String userId);

    void deleteToken(String userId);

    boolean checkRefreshToken(String userId, String token);

}