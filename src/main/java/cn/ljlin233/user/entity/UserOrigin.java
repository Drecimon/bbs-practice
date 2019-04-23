package cn.ljlin233.user.entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * UserOrigin
 */
@Setter
@Getter
@Component
public class UserOrigin {

    private int id;
    private String account;

    public UserOrigin() {};

    public UserOrigin(int id, String account) {
        this.id = id;
        this.account = account;
    } 

}