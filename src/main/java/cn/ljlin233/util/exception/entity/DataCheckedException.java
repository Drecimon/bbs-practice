package cn.ljlin233.util.exception.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * DataCheckedException
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataCheckedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public DataCheckedException(String message) {
        this.setMessage(message);
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    

}