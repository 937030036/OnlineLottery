package com.example.onlinelottery.service.iservice;

import com.example.onlinelottery.model.Award;
import com.example.onlinelottery.msg.TransMsg;

import java.util.List;

public interface IAwardHandle {

    List<Award> getAwardList(Integer id);

    TransMsg addAward(Integer id, String grade, String name, Integer num);

    TransMsg deleteAward(Integer id, String name);
}
