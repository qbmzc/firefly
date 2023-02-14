package com.cong.firefly.common;

import lombok.Data;

/**
 * @author cong
 * <p>
 * created on 2021/4/17 上午11:15
 */
@Data
public class R {
    private int code;
    private String message;
    private Object data;

    public R() {
        this.code=200;
        this.message="success";
    }

    public R(int code, String msg, Object data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public R(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public R(Object data) {
        this.code=200;
        this.message="success";
        this.data = data;
    }
}