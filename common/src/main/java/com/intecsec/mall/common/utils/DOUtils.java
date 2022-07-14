package com.intecsec.mall.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @description: bean拷贝对象类， 基于spring的
 * @author: peter.peng
 * @create: 2018-11-15 16:13
 **/
public class DOUtils {

    public static <T> T copy(Object source, Class<T> clazz) {
        if (null == source) {
            return null;
        }
        T result;
        try {
            result = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("newInstance ERROR, clz: " + clazz, e);
        }

        return copy(source, result);
    }

    public static <T> T copy(Object source, T result) {
        if (null == source || null == result) {
            return result;
        }
        try {
            BeanUtils.copyProperties( source,result);
        } catch (Exception e) {
            throw new RuntimeException("copyProperties ERROR, obj: " + source.getClass() + " clz: " + result.getClass(),
                    e);
        }
        return result;
    }

    public static <T> List<T> copyList(Collection<? extends Object> list, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        if (null != list) {
            for (Object source : list) {
                result.add(copy(source, clazz));
            }
        }
        return result;
    }
}
