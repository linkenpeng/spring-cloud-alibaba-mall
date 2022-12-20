package com.intecsec.mall.common.exception;

import com.intecsec.mall.common.enums.ResponseEnum;
import lombok.Getter;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-12-18 09:50
 **/
@Getter
public class BaseException extends Exception {
    private int code;

    public BaseException(IResponseEnum responseEnum, String message) {
        super(message);
        this.code = responseEnum.getCode();
    }

    public BaseException(IResponseEnum responseEnum, String message, Throwable cause) {
        super(message, cause);
        this.code = responseEnum.getCode();
    }

    public BaseException(IResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
    }

    public BaseException(IResponseEnum responseEnum, Throwable cause) {
        super(responseEnum.getMessage(), cause);
        this.code = responseEnum.getCode();
    }
}
