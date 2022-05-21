package com.example.onlinelottery.Controller.Page;

import com.example.onlinelottery.Model.UserMgr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexPageCtler {

    @RequestMapping(value = "index/page",method = RequestMethod.GET)
    String getIndexPage(HttpServletRequest request, Model model){
        UserMgr userMgr= (UserMgr) request.getSession().getAttribute("usermgr");
        model.addAttribute("phone",userMgr.getPhone());
        return "Index";
    }
}
