package com.example.onlinelottery.Model;

import lombok.Data;

@Data
public class UserMgr {
    private Integer id;
    private String phone;
    private Integer balance;
    private String password;
}
