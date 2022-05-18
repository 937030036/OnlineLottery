package com.example.onlinelottery.Controller.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignPageCtler {
    @RequestMapping(value = "login/page", method = RequestMethod.GET)
    String getLoginPage(Model model) {
        return "Login";
    }

    @RequestMapping(value = "register/page", method = RequestMethod.GET)
    String getRegisterPage(Model model) {
        return "Register";
    }


}
