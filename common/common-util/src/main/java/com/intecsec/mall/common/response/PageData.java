package com.intecsec.mall.common.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-01-03 22:28
 **/
@Data
public class PageData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 数据列表 */
    private List<T> list;

    /** 总数 */
    private long total;

    /** 分页大小 */
    private long size;

    /** 当前页 */
    private long current;
}
