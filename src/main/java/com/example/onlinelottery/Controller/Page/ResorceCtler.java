package com.example.onlinelottery.Controller.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ResorceCtler {
    @RequestMapping(value = "agreement",method = RequestMethod.GET)
    @ResponseBody
    String getAgreement(HttpServletRequest request, HttpServletResponse response){
        return "没有用户使用协议！！！";
    }
}
