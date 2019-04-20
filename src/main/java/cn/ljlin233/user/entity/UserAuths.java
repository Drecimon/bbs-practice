package cn.ljlin233.user.entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * UserAuths
 */
@Setter
@Getter
@Component
public class UserAuths {

    private int id;
    private int userId;
    private String identityType;
    private String identifier;
    private String credential;

    public UserAuths() {}

    public UserAuths (int id, int userId, String identityType, String identifier, String credential ) {
        this.id = id;
        this.userId = userId;
        this.identityType = identityType;
        this.identifier = identifier;
        this.credential = credential;
    }

}