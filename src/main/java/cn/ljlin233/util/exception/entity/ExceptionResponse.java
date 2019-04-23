package cn.ljlin233.util.exception.entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * ExceptionResponse
 */
@Setter
@Getter
@Component
public class ExceptionResponse {

    private String code;

    private String message;

    public ExceptionResponse() {};

    public ExceptionResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
}