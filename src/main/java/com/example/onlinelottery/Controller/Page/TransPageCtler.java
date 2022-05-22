package com.example.onlinelottery.Controller.Page;

import com.example.onlinelottery.Model.Award;
import com.example.onlinelottery.Model.Schema;
import com.example.onlinelottery.Model.UserMgr;
import com.example.onlinelottery.Service.IService.IAwardHandle;
import com.example.onlinelottery.Service.IService.ILotteryHandle;
import com.example.onlinelottery.Service.IService.ISchemaHandle;
import com.example.onlinelottery.Service.IService.IUserHandle;
import com.example.onlinelottery.Service.ServiceImpl.SchemaHandleService;
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
