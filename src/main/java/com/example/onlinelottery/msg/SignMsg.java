package com.example.onlinelottery.msg;

public enum SignMsg {
    LOGIN_SUCC("登录成功"),
    REGISTER_SUCC("注册成功"),
    PHONE_EXIST("电话已存在,请重试"),
    PHONE_NOEXIST("电话不存在，请注册"),
    PASSWORD_WRONG("密码错误，请重试"),

    VERIFY_WRONG("验证码错误"),
    MODIFYPWD_SUCC("密码修改成功"),
    FIRST_LOGIN("首次登录"),

    NO_MSG("");

    private final String msg;

    SignMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
