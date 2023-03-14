package com.zdz.handler;

import com.zdz.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ControllerAdvice对加了Controller注解的方法进行拦截处理  AOP的实现
 */
@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException (Exception ex){
        ex.printStackTrace();
        return Result.fail(-999,"系统异常");
    }
}
