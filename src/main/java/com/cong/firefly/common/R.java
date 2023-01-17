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
    private String msg;
    private Object body;

    public R() {
        this.code=200;
        this.msg="success";
    }

    public R(int code, String msg, Object body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
    }

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(Object body) {
        this.code=200;
        this.msg="success";
        this.body = body;
    }
}