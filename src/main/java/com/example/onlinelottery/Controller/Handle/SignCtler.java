package com.example.onlinelottery.Controller.Handle;

import com.example.onlinelottery.Model.UserMgr;
import com.example.onlinelottery.Msg.SignMsg;
import com.example.onlinelottery.Service.ServiceImpl.SignHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@Controller
public class SignCtler {
    @Autowired
    private SignHandleService signHandleService;
    private SignMsg signMsg;

    @RequestMapping(value = "login-handle", method = RequestMethod.GET)
    String loginHandle(HttpServletRequest request, Model model) {
        signMsg = signHandleService.LoginHandle(request);
        model.addAttribute("msg", signMsg.toString());
        if (signMsg.equals(SignMsg.PASSWORD_WRONG)) {
            return "Login";
        } else if (signMsg.equals(SignMsg.FIRST_LOGIN)) {

            return "FirstLogin";
        } else if (signMsg.equals(SignMsg.PHONE_NOEXIST)) {
            return "Register";
        } else if (signMsg.equals(SignMsg.LOGIN_SUCC)) {
            UserMgr userMgr= (UserMgr) request.getSession().getAttribute("usermgr");
            model.addAttribute("phone",userMgr.getPhone());
            return "Index";
        } else {
            //TODO exception page
            return null;
        }
    }

    @RequestMapping(value = "usermgr", method = RequestMethod.POST)
    String registerHandle(HttpServletRequest request, Model model) {
        String phone = new String((request.getParameter("phone")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String verifycode = new String((request.getParameter("verifycode")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        signMsg = signHandleService.RegisterHandle(phone, verifycode);
        model.addAttribute("msg", signMsg.toString());
        if (signMsg.equals(SignMsg.REGISTER_SUCC)) {
            return "Login";
        } else if (signMsg.equals(SignMsg.PHONE_EXIST)) {
            return "Register";
        } else {
            //TODO exception page
            return null;
        }
    }

    @RequestMapping(value = "password", method = RequestMethod.PUT)
    String modifyHandle(HttpServletRequest request, Model model) {
        String ver1 = (String) request.getSession().getAttribute("verify");
        String pwd = new String((request.getParameter("pwd")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String email = new String((request.getParameter("email")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String ver2 = new String((request.getParameter("verify")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        Integer id = userMgr.getId();
        if (!ver1.equals(ver2)) {
            signMsg = SignMsg.VERIFY_WRONG;
            model.addAttribute("msg", signMsg.toString());

        } else {
            signMsg = signHandleService.ModifypwdHandle(id, pwd, email);
            model.addAttribute("msg", signMsg.toString());
        }
        if (signMsg.equals(SignMsg.VERIFY_WRONG)) {
            return "FirstLogin";
        } else if (signMsg.equals(SignMsg.MODIFYPWD_SUCC)) {
            return "Login";
        } else {
            //TODO exception
            return null;
        }
    }
}
