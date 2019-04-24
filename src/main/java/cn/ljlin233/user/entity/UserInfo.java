package cn.ljlin233.user.entity;


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
    private String registerTime;
    private String profilePicture;
    private Integer active;
    private String activeId;
    private Integer isban;
    
    
    public UserInfo() {}


    public UserInfo (int id, String account, String email, String phone, String nickname, 
        String introduction, String registerTime, String profilePicture, int active, String activeId, int isban) {
        
        this.id = id;
        this.account = account;
        this.email = email;
        this.phone = phone;
        this.nickname = nickname;
        this.introduction = introduction;
        this.registerTime = registerTime;
        this.profilePicture = profilePicture;
        this.active = active;
        this.activeId = activeId;
        this.isban = isban;

    }

    @Override
    public String toString() {
        return "UserInfo [account=" + account + ", active=" + active + ", activeId=" + activeId + ", email=" + email
                + ", id=" + id + ", introduction=" + introduction + ", isban=" + isban + ", nickname=" + nickname
                + ", phone=" + phone + ", profilePicture=" + profilePicture + ", registerTime=" + registerTime + "]";
    }


    
}