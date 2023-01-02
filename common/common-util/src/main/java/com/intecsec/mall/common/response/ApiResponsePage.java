package com.intecsec.mall.common.response;

import com.intecsec.mall.common.enums.ResponseEnum;
import com.intecsec.mall.common.exception.IResponseEnum;
import com.intecsec.mall.common.utils.TraceUtils;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * @description: 输出分页结果
 * @author: peter.peng
 * @create: 2018-11-02 11:04
 **/
@Getter
@Setter
public class ApiResponsePage<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private T data;

    /** 总数 */
    private long total;
    /** 分页大小 */
    private long size;
    /** 当前页 */
    private long current;

    private String traceId;

    @PostConstruct
    private void init() {
        try {
            this.traceId = TraceUtils.currentTraceId();
        } catch (Exception e) {

        }
    }

    public ApiResponsePage() {

    }

    public ApiResponsePage(T data) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = ResponseEnum.SUCCESS.getMessage();
        this.data = data;
        this.init();
    }

    public ApiResponsePage(T data, long total) {
        this(data);
        this.total = total;
    }

    public ApiResponsePage(int code, String message) {
        this.code = code;
        this.message = message;
        this.init();
    }


    public ApiResponsePage(IResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.init();
    }
}
