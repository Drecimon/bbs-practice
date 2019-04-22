package cn.ljlin233.util.verification.service;

import java.awt.image.BufferedImage;

import cn.ljlin233.util.verification.entity.Verification;

/**
 * VerificationService
 */
public interface VerificationService {

    
    String getVerificationId();

    String getVerificationCode(String verId);

    boolean checkVerification(String verId, String verCode);

    BufferedImage getVerificationImage(String verCode);

    Verification getVerification();

}