package com.example.onlinelottery.controller.page;

import com.example.onlinelottery.service.iservice.ISignHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignPageCtler {
    @Autowired
    private ISignHandle signHandle;
    @RequestMapping(value = "login/page", method = RequestMethod.GET)
    String getLoginPage() {
        return "Login";
    }

    @RequestMapping(value = "register/page", method = RequestMethod.GET)
    String getRegisterPage() {
        return "Register";
    }

    @RequestMapping(value = "modifypwd/page",method = RequestMethod.GET)
    String getModifypwdPage(HttpServletRequest request){
        return "FirstLogin";
    }
}
