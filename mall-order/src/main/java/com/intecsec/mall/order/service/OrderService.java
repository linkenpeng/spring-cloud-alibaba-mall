package com.intecsec.mall.order.service;

import com.intecsec.mall.order.dto.AddOrderDTO;
import com.intecsec.mall.order.dto.OrderDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-11-26 19:28
 **/
public interface OrderService {

    OrderDTO addOrder(AddOrderDTO addOrderDTO);

    OrderDTO getOrder(long id);

    List<OrderDTO> getOrderList(int page, int pageSize);

    OrderDTO getUserOrder(long id, long userId);

    List<OrderDTO> getUserOrderList(int page, int pageSize, long userId);
}
