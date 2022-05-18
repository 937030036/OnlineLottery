package com.example.onlinelottery.Dao;

import com.example.onlinelottery.Model.UserMgr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMgrMapper {
    @Select("select id,phone,balance from UserMgr")
    List<UserMgr> getUserMgrList();

    @Select("select id,phone,balance from UserMgr where id=#{id}")
    UserMgr getUserMgrById(String id);

    @Insert("insert into UserMgr value(#{id},#{phone},#{balance})")
    Integer addUserMgr(UserMgr userMgr);
}
