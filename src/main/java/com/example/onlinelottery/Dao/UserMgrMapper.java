package com.example.onlinelottery.Dao;

import com.example.onlinelottery.Model.UserMgr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMgrMapper {
    @Select("select id,phone,name,balance from UserMgr")
    List<UserMgr> getUserMgrList();

}
