package cn.ljlin233.util.exception.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.NoHandlerFoundException;

import cn.ljlin233.util.exception.entity.DataCheckedException;
import cn.ljlin233.util.exception.entity.ExceptionResponse;

/**
 * GlobalExceptionController
 */
@ControllerAdvice
public class GlobalExceptionController extends DispatcherServlet {

    private static final long serialVersionUID = 5449367539552766714L;

    @Autowired
    private ExceptionResponse exceptionResponse;

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public Map<String, String> handleNotFound404Exception(HttpServletRequest request) {  
        Map<String, String> map = new HashMap<>();
        map.put("code", "404");
        map.put("url", request.getRequestURI());
        return map;  
    }  

    @ExceptionHandler(DataCheckedException.class)
    @ResponseBody
    public ExceptionResponse handleDataCheckedException(DataCheckedException ex) {
        exceptionResponse.setCode("400");
        exceptionResponse.setMessage(ex.getMessage());

        return exceptionResponse;
    }
    
}