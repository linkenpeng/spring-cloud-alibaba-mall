package com.intecsec.mall.common.enums;

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
public enum ResponseEnum implements IResponseEnum {
    SUCCESS(20000, "请求处理成功"),
    SYSTEM_ERROR(50000, "系统错误"),
    ;
    private int code;
    private String message;
}
