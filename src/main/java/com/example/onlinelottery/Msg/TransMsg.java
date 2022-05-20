package com.example.onlinelottery.Msg;

public enum TransMsg {
    ADDUSER_SUCC("增加用户成功"),
    ADDUSER_FAIL("用户已存在"),

    DELETEUSER_SUUC("删除用户成功"),

    DELETEUSER_FAIL("删除用户失败，请核对信息"),

    SEARCHUSER_SUCC("查询用户成功"),

    SEARCHUSER_FAIL("查询不到此用户"),

    NO_MSG("");

    private final String msg_str;

    TransMsg(String msg) {
        msg_str = msg;
    }

    @Override
    public String toString() {
        return msg_str;
    }
}
