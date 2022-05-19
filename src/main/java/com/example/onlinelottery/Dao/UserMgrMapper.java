package com.example.onlinelottery.Dao;

import com.example.onlinelottery.Model.UserMgr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMgrMapper {
    @Select("select id,phone,balance,password from UserMgr")
    List<UserMgr> getUserMgrList();

    @Select("select id,phone,balance,password from UserMgr where id=#{id}")
    UserMgr getUserMgrById(String id);

    @Select("select id,phone,balance,password from UserMgr where id=#{phone}")
    UserMgr getUserMgrByPhone(String phone);

    @Insert("insert into UserMgr value(#{id},#{phone},#{balance},#{password})")
    void addUserMgr(UserMgr userMgr);
}
