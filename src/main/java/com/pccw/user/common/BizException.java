package com.pccw.user.common;


/**
 *
 * 常见业务异常
 */
public class BizException extends BaseException {

    public BizException(Integer code) {
        super(code);
    }

    public BizException(Integer code, String msg) {
        super(code, msg);
    }

    public BizException(int code, Throwable t) {
        super(code, t);
    }

    public BizException(int code, String msg, Throwable t) {
        super(code, msg, t);
    }
}