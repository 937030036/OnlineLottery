package com.example.onlinelottery.Controller.Page;

import com.example.onlinelottery.Model.UserMgr;
import com.example.onlinelottery.Service.IService.ITransHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TransPageCtler {

    @Autowired
    private ITransHandle transHandle;

    @RequestMapping(value = "rule/page", method = RequestMethod.GET)
    String getRulePage(Model model) {
        //TODO
        return null;
    }

    @RequestMapping(value = "user/page", method = RequestMethod.GET)
    String getUserPage(HttpServletRequest request, Model model) {
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        model.addAttribute("data", transHandle.getUserList(userMgr.getId()));
        return "User";
    }

    @RequestMapping(value = "award/page", method = RequestMethod.GET)
    String getAwardPage(Model model) {
        //todo
        return null;
    }

    @RequestMapping(value = "history/page", method = RequestMethod.GET)
    String getHistoryPage(Model model) {
        //todo
        return null;
    }

}
