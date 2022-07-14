package com.intecsec.mall.common.Enums;

/**
 * @description: 响应码
 * @author: peter.peng
 * @create: 2018-11-02 10:59
 **/
public enum ResponseEnum {
    REQUEST_SUCESS(10000, "请求处理成功"),

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

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
