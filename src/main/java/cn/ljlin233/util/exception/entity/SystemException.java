package cn.ljlin233.util.exception.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * SystemException
 */
@Setter
@Getter
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String friendMessage;

    private String message;

    public SystemException() {};

    public SystemException(String friendMessage, String message) {
        this.friendMessage = friendMessage;
        this.message = message;
    }
    
}