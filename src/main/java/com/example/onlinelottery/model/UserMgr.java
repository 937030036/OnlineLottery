package com.example.onlinelottery.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserMgr {
    private Integer id;
    private String phone;
    private Integer balance;
    private String password;
    private String email;
}
