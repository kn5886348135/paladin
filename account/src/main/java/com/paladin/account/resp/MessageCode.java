package com.paladin.account.resp;


/**
 *  @author: paladin
 *  @Description: 业务状态吗
 *  @date: created in 2020/8/25 21:06
 */
public enum MessageCode {
    // 成功
    SUCCESS(200,"请求成功"),

    // 失败
    VALIDATE_FAILURE(4001,"参数校验失败"),

    // 未认证（签名错误）
    LOGIN_FAILURE(4010,"登陆失败"),

    LOGIN_TIMEOUT(4011,"登录超时"),

    AUTHENCATION_FAILURE(4012,"认证失败"),

    AUTHENCATION_TIMEOUT(4012,"认证超时"),

    FORBIDDEN_CSRF(4030,"CSRF校验失败"),

    // 接口不存在
    NOT_FOUND(404,"接口不存在"),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500,"服务器内部错误");


    public int code;
    public String msg;

    MessageCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
