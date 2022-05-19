package com.example.onlinelottery.Controller.Page;

import com.example.onlinelottery.Service.IService.ISignHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

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
