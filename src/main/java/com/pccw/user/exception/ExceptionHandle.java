package com.pccw.user.exception;


import com.pccw.user.common.ApiResponse;
import com.pccw.user.common.BizCodeEnum;
import com.pccw.user.common.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ApiResponse handle(Exception e){
        log.error(e.getMessage(), e);
        return ApiResponse.buildFail(BizCodeEnum.UN_KNOWN.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = BizException.class)
    public ApiResponse handle(BizException e){
        log.error("[BizException]" + e.getMessage(), e);
        return ApiResponse.buildFail(BizCodeEnum.BIZ_ERROR.getCode(), e.getMessage());
    }
}
