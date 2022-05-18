package com.example.onlinelottery.Service.IService;

import com.example.onlinelottery.Msg.SignMsg;

public interface ISignHandle {

    public SignMsg RegisterHandle(String phone,String verifycode);
}
