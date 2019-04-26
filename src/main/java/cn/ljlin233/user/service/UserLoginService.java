package cn.ljlin233.user.service;

import cn.ljlin233.user.entity.UserToken;

/**
 * UserLoginService
 */
public interface UserLoginService {

    
    UserToken userLogin(String identifier, String credential);

}