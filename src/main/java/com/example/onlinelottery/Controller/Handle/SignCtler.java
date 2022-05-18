package com.example.onlinelottery.Controller.Handle;

import com.example.onlinelottery.Msg.SignMsg;
import com.example.onlinelottery.Service.ServiceImpl.SignHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOError;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class SignCtler {
    @Autowired
    private SignHandleService signHandleService;
    private SignMsg signMsg;

    @RequestMapping(value = "login-handle", method = RequestMethod.GET)
    String loginHandle(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @RequestMapping(value = "usermgr", method = RequestMethod.POST)
    void registerHandle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phone = new String((request.getParameter("phone")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String verifycode = new String((request.getParameter("verifycode")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        signMsg = signHandleService.RegisterHandle(phone, verifycode);
        request.setAttribute("msg", signMsg.toString());
        if (signMsg.equals(SignMsg.REGISTER_SUCC)) {
            response.sendRedirect(request.getContextPath() + "login/page");
        } else {
            response.sendRedirect(request.getContextPath() + "register/page");
        }

    }

    @RequestMapping(value = "password", method = RequestMethod.POST)
    String modifyHandle(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
