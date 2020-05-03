package com.tazine.evo.webflux.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author jiaer.ly
 * @date 2020/04/23
 */
//@RestControllerAdvice
public class CustomErrorHandler {

    @ExceptionHandler(Exception.class)
    public String convertExceptionMsg(Exception e){
        //自定义逻辑，可返回其他值
        return "error";
    }

}
