package com.example.onlinelottery.Dao;

import com.example.onlinelottery.Model.Award;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AwardMapper {
    @Select("select grade,name,pic from #{id}_award")
    List<Award> getAwardListByUserMgr(String id);

    @Select("select grade,name,pic from Award where grade=#{grade}")
    Award getAwardByGrade(String grade);

    @Select("select grade,name,pic from Award where name=#{name}")
    Award getAwardByName(String name);

    @Select("select grade,name,pic from Award where pic=#{pic}")
    Award getAwardByPic(String pic);

    @Insert("insert into Award(grade,name,pic) value(#{grade},#{name},#{pic})")
    void addAward(Award award);
}
