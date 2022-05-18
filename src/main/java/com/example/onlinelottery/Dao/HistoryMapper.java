package com.example.onlinelottery.Dao;

import com.example.onlinelottery.Model.History;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HistoryMapper {
    @Select("select userid,grade from #{id}_history")
    List<History> getHistoryListByUserMgr(String id);
}
