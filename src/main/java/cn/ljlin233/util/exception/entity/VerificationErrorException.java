package cn.ljlin233.util.exception.entity;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
/**
 * VerificationErrorException
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "验证码错误")
public class VerificationErrorException extends RuntimeException {

    private static final long serialVersionUID = -762470325524702432L;


}