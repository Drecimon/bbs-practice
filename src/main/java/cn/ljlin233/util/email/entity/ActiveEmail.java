package cn.ljlin233.util.email.entity;


import lombok.Getter;
import lombok.Setter;

/**
 * ActiveEmail
 */
@Setter
@Getter
public class ActiveEmail {

    private String sendTo;

    private String title;

    private String message;

    private String sendFrom;

    public ActiveEmail() {};

    public ActiveEmail(String sendFrom, String sendTo, String title, String message) {
        this.sendFrom = sendFrom;
        this.sendTo = sendTo;
        this.title = title;
        this.message = message; 
    }
    
}