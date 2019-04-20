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
    private int userToken;

    public UserToken() {};

    public UserToken(int userId, int userToken) {
        this.userId = userId;
        this.userToken = userToken;
    }
    
}