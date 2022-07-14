package com.intecsec.mall.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-24 11:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderDTO implements Serializable {

    private Long user_id;

    private Long consignee_id;

    private List<AddOrderItemDTO> order_item_list;
}