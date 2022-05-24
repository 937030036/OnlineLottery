package com.example.onlinelottery.msg;

public enum TransMsg {
    ADDUSER_SUCC("增加用户成功"),
    ADDUSER_FAIL("用户已存在"),

    DELETEUSER_SUUC("删除用户成功"),

    DELETEUSER_FAIL("删除用户失败，请核对信息"),

    SEARCHUSER_SUCC("查询用户成功"),

    SEARCHUSER_FAIL("查询不到此用户"),

    ADDAWARD_SUCC("增加奖品成功"),

    ADDAWARD_FAIL("奖品已存在"),

    DELETEAWARD_SUCC("删除奖品成功"),

    DELETEAWARD_FAIL("奖品不存在"),

    ADDSCHEMA_SUCC("增加模式成功"),

    ADDSCHEMA_FAIL("模式已存在"),

    DELETESCHEMA_SUCC("删除模式成功"),

    SETSCHEMA_SUCC("设置模式成功"),

    LAUNCHLOTTERY_SUCC("发起抽奖成功"),

    LAUNCHLOTTERY_FAIL("奖池或用户不存在"),

    DELETEHISTORY_SUCC("删除记录成功"),

    NO_MSG("");

    private final String msg;

    TransMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
