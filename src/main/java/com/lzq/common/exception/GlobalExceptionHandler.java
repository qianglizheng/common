package com.lzq.common.exception;

import com.lzq.common.enums.ReturnCodeEnum;
import com.lzq.common.util.ResultDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //返回状态码为500
    public ResultDataUtil<String> exceptionHandler(Exception e) {
        log.error("全局异常信息：{}", e.getMessage());
        return ResultDataUtil.fail(ReturnCodeEnum.RC500);
    }
}
