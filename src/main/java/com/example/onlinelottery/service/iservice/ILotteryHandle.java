package com.example.onlinelottery.service.iservice;

import com.example.onlinelottery.model.History;
import com.example.onlinelottery.msg.TransMsg;

import java.util.List;

public interface ILotteryHandle {
    TransMsg launchLottery(Integer id, String lotteryname);

    List<History> getLotteryList(Integer id);

    List<History> getLotteryList(Integer id, String lotteryname);

    TransMsg deleteLottery(Integer id, String lotteryname);
}
