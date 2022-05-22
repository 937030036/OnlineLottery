package com.example.onlinelottery.Service.ServiceImpl;

import com.example.onlinelottery.Dao.AwardMapper;
import com.example.onlinelottery.Dao.HistoryMapper;
import com.example.onlinelottery.Dao.UserMapper;
import com.example.onlinelottery.Model.Award;
import com.example.onlinelottery.Model.History;
import com.example.onlinelottery.Model.User;
import com.example.onlinelottery.Msg.TransMsg;
import com.example.onlinelottery.Service.IService.ILotteryHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LotteryHandleService implements ILotteryHandle {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private AwardMapper awardMapper;

    @Override
    public TransMsg launchLottery(Integer id, String lotteryname) {
        List<Award> awardList = awardMapper.getAwardListByUserMgr(id);
        List<User> userList = userMapper.getUserListByUserMgr(id);
        Random random = new Random();
        if (awardList == null) {
            return TransMsg.LAUNCHLOTTERY_FAIL;
        }
        if (userList == null) {
            return TransMsg.LAUNCHLOTTERY_FAIL;
        }
        for (var award : awardList) {
            for (int i = 0; i < award.getNum(); i++) {
                if (userList.isEmpty()) {
                    return TransMsg.LAUNCHLOTTERY_SUCC;
                }
                int index = random.nextInt(userList.size());
                History history = new History();
                history.setUsername(userList.remove(index).getName());
                history.setLotteryname(lotteryname);
                history.setGrade(award.getGrade());
                history.setAward(award.getName());
                historyMapper.addHistory(id, history);
            }
        }
        return TransMsg.LAUNCHLOTTERY_SUCC;
    }

    @Override
    public List<History> getLotteryList(Integer id) {
        return historyMapper.getHistoryListByUserMgr(id);
    }

    @Override
    public List<History> getLotteryList(Integer id, String lotteryname) {
        return historyMapper.getHistoryListByLotteryName(id, lotteryname);
    }

    @Override
    public TransMsg deleteLottery(Integer id, String lotteryname) {
        historyMapper.deleteHistory(id, lotteryname);
        return TransMsg.DELETEHISTORY_SUCC;
    }
}
