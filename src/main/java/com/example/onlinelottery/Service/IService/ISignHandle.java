package com.example.onlinelottery.Service.IService;

import com.example.onlinelottery.Msg.SignMsg;

import javax.servlet.http.HttpServletRequest;

public interface ISignHandle {

    SignMsg RegisterHandle(String phone,String verifycode);

    SignMsg LoginHandle(HttpServletRequest request);

    SignMsg ModifypwdHandle(Integer id,String pwd,String email);
}
