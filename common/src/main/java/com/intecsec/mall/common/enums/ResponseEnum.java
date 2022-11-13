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
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
