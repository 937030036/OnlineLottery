package com.example.onlinelottery.Dao;

import com.example.onlinelottery.Model.UserMgr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMgrMapper {
    @Select("select id,phone,balance,password,email,appschema from UserMgr")
    List<UserMgr> getUserMgrList();

    @Select("select id,phone,balance,password,email,appschema from UserMgr where id=#{id}")
    UserMgr getUserMgrById(Integer id);

    @Select("select id,phone,balance,password,email,appschema from UserMgr where phone=#{phone}")
    UserMgr getUserMgrByPhone(String phone);

    @Insert("insert into UserMgr(id,phone,balance,password,email) value(#{id},#{phone},#{balance},#{password},#{email})")
    void addUserMgr(UserMgr userMgr);

    @Update("update UserMgr set password=#{password},email=#{email} where id=#{id}")
    void updateUserMgrByPhone(Integer id, String password, String email);

    @Select("select appschema from usermgr where id=#{id}")
    String getAppSchemaById(Integer id);

    @Update("update usermgr set appschema=#{appschema} where id=#{id}")
    void setAppSchemaById(Integer id, String appschema);
}
