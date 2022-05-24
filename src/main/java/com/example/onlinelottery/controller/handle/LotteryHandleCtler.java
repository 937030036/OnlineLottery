package com.example.onlinelottery.controller.handle;

import com.example.onlinelottery.model.UserMgr;
import com.example.onlinelottery.msg.TransMsg;
import com.example.onlinelottery.service.iservice.ILotteryHandle;
import com.example.onlinelottery.service.iservice.ISchemaHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class LotteryHandleCtler {
    @Autowired
    private ILotteryHandle lotteryHandle;

    @Autowired
    private ISchemaHandle schemaHandle;
    private TransMsg transMsg;

    @RequestMapping(value = "lottery", method = RequestMethod.POST)
    String launchLottery(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String lotteryname = request.getParameter("lotteryname");
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        transMsg = lotteryHandle.launchLottery(userMgr.getId(), lotteryname);
        model.addAttribute("appschema",schemaHandle.getAppSchema(userMgr.getId()));
        model.addAttribute("msg", transMsg.toString());
        model.addAttribute("data", lotteryHandle.getLotteryList(userMgr.getId(), lotteryname));
        return "Lottery";
    }
}
