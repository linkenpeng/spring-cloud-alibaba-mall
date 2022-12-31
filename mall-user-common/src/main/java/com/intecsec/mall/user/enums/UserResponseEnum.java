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

    USER_NOT_EXISTS(20002, "用户不存在"),

    PASSWORD_INVALID(20003, "密码不正确"),

    ;

    private int code;

    private String message;
}
