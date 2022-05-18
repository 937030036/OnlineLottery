package com.example.onlinelottery.Dao;

import com.example.onlinelottery.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select id,phone,name from #{userMgr}_user")
    List<User> getUserListByUserMgr(String userMgr);
}
