package com.cest.core.exception;

import com.cest.common.util.CodeMsg;
import com.cest.common.util.Result;
import org.springframework.validation.ObjectError;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * Created by cestlavie on 2019/9/23.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(Exception e){
        e.printStackTrace();

        if(e instanceof BindException){
            BindException ex = (BindException)e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        }else if(e instanceof DefineException){
            DefineException ex = (DefineException)e;
            return Result.error(ex.getCm());
        }else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
