package com.example.onlinelottery.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Welcome {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }
}