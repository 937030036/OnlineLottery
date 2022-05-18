package com.example.onlinelottery.Dao;

import com.example.onlinelottery.Model.Award;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AwardMapper {
    @Select("select grade,name,pic from #{userMgr}_award")
    List<Award> getAwardListByUserMgr(String userMgr);
}
