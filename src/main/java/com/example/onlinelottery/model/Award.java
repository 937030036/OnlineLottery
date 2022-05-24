package com.example.onlinelottery.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Award {
    private String grade;
    private String name;
    private Integer num;
}
