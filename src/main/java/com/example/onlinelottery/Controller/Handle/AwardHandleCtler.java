package com.example.onlinelottery.Controller.Handle;

import com.example.onlinelottery.Model.Award;
import com.example.onlinelottery.Model.UserMgr;
import com.example.onlinelottery.Msg.TransMsg;
import com.example.onlinelottery.Service.IService.IAwardHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class AwardHandleCtler {
    @Autowired
    private IAwardHandle awardHandle;

    private TransMsg transMsg;

    @RequestMapping(value = "award", method = RequestMethod.POST)
    String addAward(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String grade = request.getParameter("grade");
        String name = request.getParameter("name");
        String num = new String((request.getParameter("num")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Integer numi = Integer.parseInt(num);
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        transMsg = awardHandle.addAward(userMgr.getId(), grade, name, numi);
        model.addAttribute("msg", transMsg.toString());
        List<Award> awardList = awardHandle.getAwardList(userMgr.getId());
        model.addAttribute("data", awardList);
        return "Award";
    }

    @RequestMapping(value = "award", method = RequestMethod.DELETE)
    String deleteAward(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        transMsg = awardHandle.deleteAward(userMgr.getId(), name);
        model.addAttribute("msg", transMsg.toString());
        List<Award> awardList = awardHandle.getAwardList(userMgr.getId());
        model.addAttribute("data", awardList);
        return "Award";
    }
}
