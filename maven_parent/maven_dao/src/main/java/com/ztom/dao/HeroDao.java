package com.ztom.dao;

import com.ztom.domain.Hero;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/28 13:16
 */
public interface HeroDao {

    @Results({
            @Result(id = true,column = "hero_id",property = "heroId"),
            @Result(column = "hero_name",property = "heroName"),
    })
    @Select("select * from hero")
    List<Hero> findAll();
}
