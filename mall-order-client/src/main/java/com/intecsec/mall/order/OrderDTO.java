package com.intecsec.mall.order;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 18:59
 **/
@Data
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 3605090448492784521L;

    private Long id;

    private String orderSn;

    private Long userId;

    private Integer orderStatus;

    private Long priceAmount;

    private Long discountAmount;

    private Long couponAmount;

    private Long pointAmount;

    private Long deliveryFee;

    private Long payAmount;

    private Date gmtCreated;

    private Date gmtUpdate;

    private Byte deleteMark;

    private List<OrderItemDTO> orderItemList;

    private OrderConsigneeDTO orderConsignee;
}
