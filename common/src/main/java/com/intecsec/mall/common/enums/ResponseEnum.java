package com.intecsec.mall.common.enums;

/**
 * @description: 响应码
 * @author: peter.peng
 * @create: 2018-11-02 10:59
 **/
public enum ResponseEnum {
    SUCCESS(10000, "请求处理成功"),

    UNAUTHORIZED(40003, "签名验证失败"),

    ;

    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

}
