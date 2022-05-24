package com.example.onlinelottery.dao;

import com.example.onlinelottery.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select id,phone,name from #{id}_user")
    List<User> getUserListByUserMgr(Integer id);

    @Insert("insert into #{mid}_user(id,name,phone) values(#{user.id},#{user.name},#{user.phone})")
    void addUser(Integer mid, User user);

    @Delete("delete from #{mid}_user where name=#{user.name} and phone=#{user.phone}")
    Integer deleteUser(Integer mid, User user);

    @Select("select id,phone,name from #{id}_user where name=#{name}")
    User gerUserByName(Integer id, String name);

    @Select("select id,phone,name from #{id}_user where phone=#{phone}")
    User gerUserByPhone(Integer id, String phone);
}
