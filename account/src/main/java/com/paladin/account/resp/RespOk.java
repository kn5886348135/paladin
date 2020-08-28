package com.paladin.account.resp;

import java.io.Serializable;

/**
 *  @author: paladin
 *  @Description:
 *  @date: created in 2020/8/26 19:55
 */
public class RespOk implements Serializable {
    private static final long serialVersionUID = -8560991660343087086L;

    private  int code;
    private  String message;
    private  Object data;

    public RespOk(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public RespOk(Object data) {
        this.code = 200;
        this.message = "请求成功";
        this.data = data;
    }

}
