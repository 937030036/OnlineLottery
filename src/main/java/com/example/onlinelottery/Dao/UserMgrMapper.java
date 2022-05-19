package com.example.onlinelottery.Dao;

import com.example.onlinelottery.Model.UserMgr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMgrMapper {
    @Select("select id,phone,balance,password,email from UserMgr")
    List<UserMgr> getUserMgrList();

    @Select("select id,phone,balance,password,email from UserMgr where id=#{id}")
    UserMgr getUserMgrById(String id);

    @Select("select id,phone,balance,password,email from UserMgr where phone=#{phone}")
    UserMgr getUserMgrByPhone(String phone);

    @Insert("insert into UserMgr(id,phone,balance,password,email) value(#{id},#{phone},#{balance},#{password},#{email})")
    void addUserMgr(UserMgr userMgr);
}
