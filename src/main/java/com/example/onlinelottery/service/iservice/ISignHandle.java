package com.example.onlinelottery.service.iservice;

import com.example.onlinelottery.msg.SignMsg;

import javax.servlet.http.HttpServletRequest;

public interface ISignHandle {

    SignMsg registerHandle(String phone, String verifycode);

    SignMsg loginHandle(HttpServletRequest request);

    SignMsg modifypwdHandle(Integer id, String pwd, String email);
}
