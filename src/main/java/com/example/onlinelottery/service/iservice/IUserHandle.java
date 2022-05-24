package com.example.onlinelottery.service.iservice;

import com.example.onlinelottery.model.User;
import com.example.onlinelottery.msg.TransMsg;

import java.util.List;

public interface IUserHandle {
    List<User> getUserList(Integer id);

    TransMsg addUser(Integer id, String name, String phone);

    TransMsg deleteUser(Integer id, String name, String phone);

    User searchUser(Integer id, String name);

    User searchUser(String phone, Integer id);
}
