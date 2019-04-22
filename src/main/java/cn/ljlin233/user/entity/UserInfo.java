package cn.ljlin233.user.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * UserInfo
 */
@Setter
@Getter
@Component
public class UserInfo {

    private int id;
    private String account;
    private String email;
    private String phone;
    private String nickname;
    private String introduction;
    private Date registerTime;
    private String profilePicture;
    private int isban;
    
    
    public UserInfo() {}


    public UserInfo (int id, String account, String email, String phone, String nickname, 
        String introduction, Date registerTime, String profilePicture, int isban) {
        
        this.id = id;
        this.account = account;
        this.email = email;
        this.phone = phone;
        this.nickname = nickname;
        this.introduction = introduction;
        this.registerTime = registerTime;
        this.profilePicture = profilePicture;
        this.isban = isban;

    }

    @Override
    public String toString() {

        return "id=" + this.id + " account=" + this.account +" email=" + this.email;
    }
    
}