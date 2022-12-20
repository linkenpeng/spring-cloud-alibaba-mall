package com.intecsec.mall.item.enums;

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
public enum ItemResponseEnum implements IResponseEnum {

    ADD_ITEM_FAIL(60001, "添加商品失败"),

    STOCK_NOT_ENOUGH(60002, "库存不足"),

    ;

    private int code;

    private String message;
}
