package com.example.onlinelottery.controller.page;

import com.example.onlinelottery.model.Award;
import com.example.onlinelottery.model.UserMgr;
import com.example.onlinelottery.service.iservice.IAwardHandle;
import com.example.onlinelottery.service.iservice.ILotteryHandle;
import com.example.onlinelottery.service.iservice.ISchemaHandle;
import com.example.onlinelottery.service.iservice.IUserHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TransPageCtler {

    @Autowired
    private IUserHandle transHandle;

    @Autowired
    private IAwardHandle awardHandle;

    @Autowired
    private ISchemaHandle schemaHandle;

    @Autowired
    private ILotteryHandle lotteryHandle;


    @RequestMapping(value = "rule/page", method = RequestMethod.GET)
    String getRulePage(Model model) {
        model.addAttribute("data", schemaHandle.getSchemaList());
        return "Schema";
    }

    @RequestMapping(value = "user/page", method = RequestMethod.GET)
    String getUserPage(HttpServletRequest request, Model model) {
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        model.addAttribute("data", transHandle.getUserList(userMgr.getId()));
        return "User";
    }

    @RequestMapping(value = "award/page", method = RequestMethod.GET)
    String getAwardPage(HttpServletRequest request, Model model) {
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        List<Award> awardList = awardHandle.getAwardList(userMgr.getId());
        model.addAttribute("data", awardList);
        return "Award";
    }

    @RequestMapping(value = "lottery/page", method = RequestMethod.GET)
    String getLotteryPage(HttpServletRequest request, Model model) {
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        model.addAttribute("appschema", schemaHandle.getAppSchema(userMgr.getId()));
        return "Lottery";
    }

    @RequestMapping(value = "history/page", method = RequestMethod.GET)
    String getHistoryPage(HttpServletRequest request, Model model) {
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        model.addAttribute("lotterylist",lotteryHandle.getLotteryList(userMgr.getId()));
        return "History";
    }

}
