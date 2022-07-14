package com.intecsec.mall.order;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-24 11:47
 **/
@Data
public class AddOrderItemDTO implements Serializable {

    private Long item_id;

    private Integer number;
    
}
