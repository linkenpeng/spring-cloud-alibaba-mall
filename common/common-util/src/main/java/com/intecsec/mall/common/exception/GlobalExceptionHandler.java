package com.intecsec.mall.common.exception;

import com.intecsec.mall.common.enums.ResponseEnum;
import com.intecsec.mall.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-12-22 11:23
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse error(Exception e) {
        log.info("出现异常", e);
        return new ApiResponse<>(ResponseEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ApiResponse error(BaseException e) {
        return new ApiResponse<>(e.getCode(), e.getMessage());
    }

}
