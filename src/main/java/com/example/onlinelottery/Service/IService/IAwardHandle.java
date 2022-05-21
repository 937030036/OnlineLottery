package com.example.onlinelottery.Service.IService;

import com.example.onlinelottery.Model.Award;
import com.example.onlinelottery.Msg.TransMsg;

import java.util.List;

public interface IAwardHandle {

    List<Award> getAwardList(Integer id);

    TransMsg addAward(Integer id, String grade, String name, Integer num);

    TransMsg deleteAward(Integer id, String name);
}
