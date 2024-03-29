package com.intecsec.mall.order.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-24 11:47
 **/
@Data
public class AddOrderItemDTO implements Serializable {

    private Long sku_id;

    private Integer number;
    
}
