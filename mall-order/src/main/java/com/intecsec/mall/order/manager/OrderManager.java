package com.intecsec.mall.order.manager;

import com.intecsec.mall.order.OrderDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:24
 **/
public interface OrderManager {

    OrderDTO getOrder(long id);

    List<OrderDTO> getOrderList(int page, int pageSize);

    OrderDTO getUserOrder(long id, long userId);

    List<OrderDTO> getUserOrderList(int page, int pageSize, long userId);

    OrderDTO addOrder(OrderDTO orderDTO);
}
