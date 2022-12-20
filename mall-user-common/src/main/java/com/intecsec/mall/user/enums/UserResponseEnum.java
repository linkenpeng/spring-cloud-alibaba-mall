package com.intecsec.mall.user.enums;

import com.intecsec.mall.common.exception.IResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 响应码
 * @author: peter.peng
 * @create: 2018-11-02 10:59
 **/
@Getter
@AllArgsConstructor
public enum UserResponseEnum implements IResponseEnum {

    USER_EXISTS(20001, "用户已存在"),

    ;

    private int code;

    private String message;
}
