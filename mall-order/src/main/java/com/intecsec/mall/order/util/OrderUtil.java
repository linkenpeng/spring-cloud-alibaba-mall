package com.intecsec.mall.order.util;

import com.intecsec.mall.common.utils.DateUtils;

import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-24 17:05
 **/
public class OrderUtil {

    public static String genOrderSn() {
        return DateUtils.formatDate(new Date(), DateUtils.YYYYMMDDHHmmssSSS);
    }

}
