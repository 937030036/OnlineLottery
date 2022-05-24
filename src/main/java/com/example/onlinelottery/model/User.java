package com.example.onlinelottery.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String phone;
    private String name;
}
