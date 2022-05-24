package com.example.onlinelottery.service.serviceimpl;

import com.example.onlinelottery.dao.TableMapper;
import com.example.onlinelottery.dao.UserMgrMapper;
import com.example.onlinelottery.model.UserMgr;
import com.example.onlinelottery.msg.SignMsg;
import com.example.onlinelottery.service.iservice.ISignHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class SignHandleService implements ISignHandle {

    @Autowired
    private UserMgrMapper userMgrMapper;

    @Autowired
    private TableMapper tableMapper;


    @Override
    public SignMsg registerHandle(String phone, String verifycode) {
        //TODO verify handle

        List<UserMgr> userMgrList = userMgrMapper.getUserMgrList();
        int userMgrid = 0;
        boolean id_increment_flg = true;

        for (var userMgr : userMgrList) {
            if (id_increment_flg) {
                userMgrid++;
                if (userMgr.getId() != userMgrid) {
                    id_increment_flg = false;
                }
            }
            if (phone.equals(userMgr.getPhone())) {
                return SignMsg.PHONE_EXIST;
            }
        }
        if (id_increment_flg) {
            userMgrid++;
        }
        UserMgr userMgr = new UserMgr();
        userMgr.setId(userMgrid);
        userMgr.setPhone(phone);
        userMgr.setBalance(0);
        userMgr.setPassword(phone);

        userMgrMapper.addUserMgr(userMgr);
        tableMapper.createUserTableByUserMgrId(userMgrid);
        tableMapper.createAwardTableByUserMgrId(userMgrid);
        tableMapper.createHistoryTableByUserMgrId(userMgrid);
        return SignMsg.REGISTER_SUCC;
    }

    @Override
    public SignMsg loginHandle(HttpServletRequest request) {
        String phone = new String((request.getParameter("phone"))
                .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = new String((request.getParameter("password"))
                .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        SignMsg signMsg;
        UserMgr userMgr = userMgrMapper.getUserMgrByPhone(phone);
        if (userMgr == null) {
            signMsg=SignMsg.PHONE_NOEXIST;;
        } else if (userMgr.getPassword().equals(password)) {
            if (password.equals(phone)) {
                request.getSession().setAttribute("usermgr", userMgr);
                signMsg=SignMsg.FIRST_LOGIN;;
            } else {
                request.getSession().setAttribute("usermgr", userMgr);
                signMsg=SignMsg.LOGIN_SUCC;
            }
        } else {
            signMsg=SignMsg.PASSWORD_WRONG;
        }
        return signMsg;
    }

    @Override
    public SignMsg modifypwdHandle(Integer id, String pwd, String email) {

        userMgrMapper.updateUserMgrByPhone(id, pwd, email);

        return SignMsg.MODIFYPWD_SUCC;
    }
}
