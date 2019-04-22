package cn.ljlin233.user.service;

/**
 * UserOriginService
 */
public interface UserOriginService {

    void addUserOrigin(String account);

    boolean checkUserOrigin(String account);

    void deleteUserOrigin(String account);

}