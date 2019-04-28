package cn.ljlin233.user.entity;


import lombok.Getter;
import lombok.Setter;

/**
 * UserOrigin
 */
@Setter
@Getter
public class UserOrigin {

    private int id;
    private String account;

    public UserOrigin() {};

    public UserOrigin(int id, String account) {
        this.id = id;
        this.account = account;
    } 

}