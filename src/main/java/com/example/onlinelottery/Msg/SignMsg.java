package com.example.onlinelottery.Msg;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public enum SignMsg {
    LOGIN_SUCC("登录成功"),
    REGISTER_SUCC("注册成功"),
    PHONE_EXIST("电话已存在,请重试"),
    PHONE_NOEXIST("电话不存在，请注册"),
    PASSWORD_WRONG("密码错误，请重试"),
    NO_MSG("");

    private String msg_str;

    SignMsg(String msg) {
        msg_str= new String("msg");
    }

    SignMsg() {
        msg_str="";
    }

    @Override
    public String toString() {
        return msg_str;
    }
}
