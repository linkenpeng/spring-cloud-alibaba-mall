package com.intecsec.mall.order.enums;

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
public enum OrderResponseEnum implements IResponseEnum {

    ADD_ORDER_FAIL(60001, "成单失败"),

    ;

    private int code;

    private String message;
}
