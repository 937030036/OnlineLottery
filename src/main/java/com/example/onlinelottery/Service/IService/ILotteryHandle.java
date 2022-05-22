package com.example.onlinelottery.Service.IService;

import com.example.onlinelottery.Model.History;
import com.example.onlinelottery.Msg.TransMsg;

import java.util.List;

public interface ILotteryHandle {
    TransMsg launchLottery(Integer id, String lotteryname);

    List<History> getLotteryList(Integer id);

    List<History> getLotteryList(Integer id, String lotteryname);

    TransMsg deleteLottery(Integer id, String lotteryname);
}
