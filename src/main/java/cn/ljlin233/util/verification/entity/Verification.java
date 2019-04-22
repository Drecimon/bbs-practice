package cn.ljlin233.util.verification.entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * Verification
 */
@Component
@Setter
@Getter
public class Verification {

    private String verificationId;

    private String verificationImage;

    public Verification() {}

    public Verification(String verificationId, String verificationImage) {
        this.verificationId = verificationId;
        this.verificationImage = verificationImage;
    }



}