package com.example.onlinelottery.service.serviceimpl;

import com.example.onlinelottery.dao.AwardMapper;
import com.example.onlinelottery.model.Award;
import com.example.onlinelottery.msg.TransMsg;
import com.example.onlinelottery.service.iservice.IAwardHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardHandleService implements IAwardHandle {
    @Autowired
    private AwardMapper awardMapper;

    @Override
    public List<Award> getAwardList(Integer id) {
        return awardMapper.getAwardListByUserMgr(id);
    }

    @Override
    public TransMsg addAward(Integer id, String grade, String name, Integer num) {
        List<Award> awardList = awardMapper.getAwardListByUserMgr(id);
        for (var award : awardList) {
            if (award.getGrade().equals(grade) || award.getName().equals(name)) {
                return TransMsg.ADDAWARD_FAIL;
            }
        }
        Award award = new Award();
        award.setGrade(grade);
        award.setName(name);
        award.setNum(num);
        awardMapper.addAward(id, award);
        return TransMsg.ADDAWARD_SUCC;
    }

    @Override
    public TransMsg deleteAward(Integer id, String name) {

        Integer ret = awardMapper.deleteAward(id, name);
        if (ret != 1) {
            return TransMsg.DELETEAWARD_FAIL;
        } else {
            return TransMsg.DELETEAWARD_SUCC;
        }
    }


}