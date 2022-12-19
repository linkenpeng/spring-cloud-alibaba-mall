package com.intecsec.mall.common.exception;

import java.text.MessageFormat;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-12-18 09:56
 **/
public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg, t);
    }

}
