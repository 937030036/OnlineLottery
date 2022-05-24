package com.example.onlinelottery.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class History {
    private String lotteryname;
    private String username;
    private String grade;
    private String award;
}
