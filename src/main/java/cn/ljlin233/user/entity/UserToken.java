package cn.ljlin233.user.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * UserToken
 */
@Setter
@Getter
public class UserToken {

    private int userId;
    private String userToken;
    private List<String> userRole;

    public UserToken() {};

    public UserToken(int userId, String userToken, List<String> userRole) {
        this.userId = userId;
        this.userToken = userToken;
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserToken [userId=" + userId + ", userRole=" + userRole + ", userToken=" + userToken + "]";
    }


}