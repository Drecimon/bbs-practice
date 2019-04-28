package cn.ljlin233.user.entity;


import lombok.Getter;
import lombok.Setter;

/**
 * UserRole
 */
@Setter
@Getter
public class UserRole {

    private int id;
    private int userId;
    private String role;

    public UserRole() {}

    public UserRole (int id, int userId, String role) {
        this.id = id;
        this.userId = userId;
        this.role = role;
    }
    
}