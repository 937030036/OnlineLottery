package com.example.onlinelottery.Controller.Handle;

import com.example.onlinelottery.Model.User;
import com.example.onlinelottery.Model.UserMgr;
import com.example.onlinelottery.Msg.TransMsg;
import com.example.onlinelottery.Service.IService.ITransHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class TransHandleCtler {
    @Autowired
    private ITransHandle transHandle;
    private TransMsg transMsg;

    @RequestMapping(value = "user", method = RequestMethod.POST)
    String addUser(HttpServletRequest request, Model model) {
        String phone = new String((request.getParameter("userphone")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String name = new String((request.getParameter("username")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        transMsg = transHandle.addUser(userMgr.getId(), name, phone);
        model.addAttribute("msg", transMsg.toString());
        List<User> userList = transHandle.getUserList(userMgr.getId());
        model.addAttribute("data", userList);
        if (transMsg.equals(TransMsg.ADDUSER_SUCC)) {
            return "User";
        } else if (transMsg.equals(TransMsg.ADDUSER_FAIL)) {
            return "User";
        } else {
            //todo exception
            return null;
        }
    }

    @RequestMapping(value = "user", method = RequestMethod.DELETE)
    String deleteUser(HttpServletRequest request, Model model) {
        String phone = new String((request.getParameter("userphone")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String name = new String((request.getParameter("username")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        transMsg = transHandle.deleteUser(userMgr.getId(), name, phone);
        model.addAttribute("msg", transMsg.toString());
        List<User> userList = transHandle.getUserList(userMgr.getId());
        model.addAttribute("data", userList);
        if (transMsg.equals(TransMsg.DELETEUSER_SUUC)) {
            return "User";
        } else if (transMsg.equals(TransMsg.DELETEUSER_FAIL)) {
            return "User";
        } else {
            //todo
            return null;
        }
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    String searchUser(HttpServletRequest request, Model model) {
        String phone = new String((request.getParameter("userphone")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String name = new String((request.getParameter("username")).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        UserMgr userMgr = (UserMgr) request.getSession().getAttribute("usermgr");
        User user = null;
        if (!phone.equals("")) {
            user = transHandle.searchUser(phone, userMgr.getId());
        } else if (!name.equals("")) {
            user = transHandle.searchUser(userMgr.getId(), name);
        }
        if (user != null) {
            model.addAttribute("data", user);
            model.addAttribute("msg", TransMsg.SEARCHUSER_SUCC);
        } else {
            List<User> userList = transHandle.getUserList(userMgr.getId());
            model.addAttribute("data", userList);
            model.addAttribute("msg", TransMsg.SEARCHUSER_FAIL);
        }
        return "User";
    }
}
