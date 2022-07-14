package com.intecsec.mall.order.util;

import com.intecsec.mall.common.utils.DateUtil;

import java.util.Date;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-24 17:05
 **/
public class OrderUtil {

    public static String genOrderSn() {
        return DateUtil.formatDate(new Date(), DateUtil.YYYYMMDDHHmmssSSS);
    }

}
