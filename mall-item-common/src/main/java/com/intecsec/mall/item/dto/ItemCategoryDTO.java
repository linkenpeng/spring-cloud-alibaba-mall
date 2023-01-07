package com.intecsec.mall.item.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-07 16:24
 **/
@Data
public class ItemCategoryDTO implements Serializable {

    private Long id;

    private String name;

    private Long parentId;
}
