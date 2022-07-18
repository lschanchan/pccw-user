package com.pccw.user.common;

/**
 *
 * @Author: huangshuren
 * @Copyright (c) 2015, lianjia.com All Rights Reserved
 */
public abstract class BaseException extends RuntimeException {

    protected Integer code;
    
    public BaseException(int code) {
        this.code = code;
    }
    
    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;
    }
    
    public BaseException(int code, Throwable t) {
        super(t);
        this.code = code;
    }
    
    public BaseException(int code, String msg, Throwable t) {
        super(msg, t);
        this.code = code;
    }
    
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}