package com.intecsec.mall.item.dto;

import lombok.Data;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-02 17:26
 **/
@Data
public class ItemQueryVO {

    private String itemName;

    private Long lowPrice;

    private Long highPrice;

    private Long categoryId;
}
