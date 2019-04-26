package cn.ljlin233.user.entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * UserToken
 */
@Setter
@Getter
@Component
public class UserToken {

    private int userId;
    private String userToken;
    private String userRole;

    public UserToken() {};

    public UserToken(int userId, String userToken, String userRole) {
        this.userId = userId;
        this.userToken = userToken;
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserToken [userId=" + userId + ", userRole=" + userRole + ", userToken=" + userToken + "]";
    }


}