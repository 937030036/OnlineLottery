package com.example.onlinelottery.Dao;

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
}
