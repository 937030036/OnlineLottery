package com.example.onlinelottery.Controller.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignPageCtler {
    @RequestMapping(value = "login/page", method = RequestMethod.GET)
    String getLoginPage(HttpServletRequest request, HttpServletResponse response) {
        return "Login";
    }

    @RequestMapping(value = "register/page", method = RequestMethod.GET)
    String getRegisterPage(HttpServletRequest request, HttpServletResponse response) {
        return "Register";
    }


}
