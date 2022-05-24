package com.example.onlinelottery.dao;

import com.example.onlinelottery.model.Schema;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchemaMapper {

    @Select("select schemaname,usermgrname,humansel,schemasel from lschema")
    List<Schema> getSchemaList();

    @Insert("insert into lschema(schemaname,usermgrname,humansel,schemasel) values" +
            "(#{schemaname},#{usermgrname},#{humansel},#{schemasel})")
    void addSchema(Schema schema);

    @Delete("delete from lschema where schemaname=#{schemaname}")
    void deleteSchema(String schemaname);
    @Select("select schemaname,usermgrname,humansel,schemasel from lschema where schemaname=#{name}")
    Schema getSchemaByName(String name);

}