package com.paladin.account.util.message;

/**
 * @author jack
 * @version 1.0
 * @description
 * @date 2023/10/04/14:54
 */
public enum MessageEnum {

    REGISTER_SUCCESS("register.success"),
    REGISTER_USERNAME_EXIST("register.username.exist"),
    REGISTER_VERIFY_CODE_MISS("register.verifycode.miss"),
    REGISTER_VERIFY_CODE_ERROR("register.verifycode.error"),
    REGISTER_FAILED("register.failed"),
    UNREGISTER_SUCCESS("unregister.success"),
    UNREGISTER_FAILED("unregister.failed"),
    PASSWORD_MODIFY_SUCCESS("password.modify.success"),
    PASSWORD_MODIFY_FAILED("password.modify.failed"),
    LOGIN_SUCCESS("login.success"),
    LOGIN_FAILED("login.failed"),
    LOGOUT_SUCCESS("logout.success"),
    LOGOUT_FAILED("logout.failed"),
    ;

    private String key;

    MessageEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
