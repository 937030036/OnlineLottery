package com.example.onlinelottery.dao;

import com.example.onlinelottery.model.History;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HistoryMapper {
    @Select("select lotteryname,username,grade,award from #{id}_history")
    List<History> getHistoryListByUserMgr(Integer id);

    @Insert("insert into #{id}_history(lotteryname,username,grade,award) values" +
            "(#{history.lotteryname},#{history.username},#{history.grade},#{history.award})")
    void addHistory(Integer id, History history);

    @Select("select lotteryname,username,grade,award from #{id}_history where lotteryname=#{lotteryname}")
    List<History> getHistoryListByLotteryName(Integer id, String lotteryname);

    @Delete("delete from #{id}_history where lotteryname=#{lotteryname}")
    void deleteHistory(Integer id, String lotteryname);
}
