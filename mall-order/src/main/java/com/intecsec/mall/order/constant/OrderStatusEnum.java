package com.intecsec.mall.order.constant;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-27 12:04
 **/
public enum  OrderStatusEnum {
    UN_PAID(10, "未支付"),
    CANCEL(20, "已取消"),
    PAID(30, "已支付"),
    DELIVERY(40, "已发货"),
    CONSIGNEED(50, "已签收"),
    REFUNDING(70, "退款中"),
    REFUNDED(80, "已退款"),
    ;

    private int orderStatus;
    private String statusName;

    OrderStatusEnum(int orderStatus, String statusName) {
        this.orderStatus = orderStatus;
        this.statusName = statusName;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public String getStatusName() {
        return statusName;
    }
}
