package com.example.onlinelottery.Service.IService;

import com.example.onlinelottery.Model.User;
import com.example.onlinelottery.Msg.TransMsg;

import java.util.List;

public interface ITransHandle {
    List<User> getUserList(Integer id);

    TransMsg addUser(Integer id, String name, String phone);

    TransMsg deleteUser(Integer id, String name, String phone);

    User searchUser(Integer id, String name);

    User searchUser(String phone, Integer id);
}
