package com.example.onlinelottery.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TableMapper {
    @Update("create table #{id}_user (" +
            "id int primary key,"+
            "phone varchar(13),"+
            "name varchar(10)"+
            ")")
    void createUserTableByUserMgrId(Integer id);

    @Update("create table #{id}_award (" +
            "grade varchar(10),"+
            "name varchar(15),"+
            "num int"+
            ")")
    void createAwardTableByUserMgrId(Integer id);

    @Update("create table #{id}_history (" +
            "lotteryname varchar(20),"+
            "username varchar(15),"+
            "grade varchar(20),"+
            "award varchar(20)"+
            ")")
    void createHistoryTableByUserMgrId(Integer id);
}
