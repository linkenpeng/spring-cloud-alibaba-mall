package com.intecsec.mall.common.exception;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-12-18 09:51
 **/
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
