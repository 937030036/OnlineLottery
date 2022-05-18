package com.example.onlinelottery.Controller.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResorceCtler {
    @RequestMapping(value = "agreement",method = RequestMethod.GET)
    @ResponseBody
    String getAgreement(Model model){
        return "没有用户使用协议！！！";
    }
}
