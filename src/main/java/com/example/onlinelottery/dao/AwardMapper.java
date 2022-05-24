package com.example.onlinelottery.dao;

import com.example.onlinelottery.model.Award;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AwardMapper {
    @Select("select grade,name,num from #{id}_award")
    List<Award> getAwardListByUserMgr(Integer id);

    @Select("select grade,name,num from #{id}_award where grade=#{grade}")
    Award getAwardByGrade(Integer id, String grade);

    @Select("select grade,name,num from #{id}_award where name=#{name}")
    Award getAwardByName(Integer id, String name);

    @Insert("insert into #{id}_award(grade,name,num) value(#{award.grade},#{award.name},#{award.num})")
    void addAward(Integer id, Award award);

    @Delete("delete from #{id}_award where name=#{name}")
    Integer deleteAward(Integer id, String name);
}
