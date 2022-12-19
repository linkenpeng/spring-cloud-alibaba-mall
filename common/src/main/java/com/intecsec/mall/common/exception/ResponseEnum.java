package com.intecsec.mall.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-12-18 09:57
 **/
@Getter
@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert {

    /**
     * Bad licence type
     */
    BAD_LICENCE_TYPE(7001, "Bad licence type."),
    /**
     * Licence not found
     */
    LICENCE_NOT_FOUND(7002, "Licence not found.")
    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}