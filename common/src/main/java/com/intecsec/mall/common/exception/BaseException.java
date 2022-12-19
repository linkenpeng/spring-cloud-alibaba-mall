package com.intecsec.mall.common.exception;

import lombok.Getter;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-12-18 09:50
 **/
@Getter
public class BaseException extends Exception {
    private int code;
    private String message;

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super(message);
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }
}
