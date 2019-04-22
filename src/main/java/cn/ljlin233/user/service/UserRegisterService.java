package cn.ljlin233.user.service;

import java.util.Date;

/**
 * UserRegisterService
 */
public interface UserRegisterService {

    void registerUser(String account, String password, String role, String email, 
        String VerificationId, String VerificationCode);

}