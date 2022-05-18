package com.example.onlinelottery.Controller.Handle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignCtler {
    @RequestMapping(value = "login-handle", method = RequestMethod.GET)
    String loginHandle(Model model) {
        return null;
    }

    @RequestMapping(value = "usermgr",method = RequestMethod.POST)
    String registerHandle(Model model){
        return null;
    }

    @RequestMapping(value = "password", method = RequestMethod.POST)
    String modifyHandle(Model model) {
        return null;
    }
}
