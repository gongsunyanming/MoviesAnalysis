package com.browse;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
//从数据库获取数据
@Mapper
public interface AppDao {

    @Select("select name, value from part1 order by name ")
    public List<Map<String, Object>> getpart1();

    @Select("select name, value from part2 order by value desc limit 100")
    List<Map<String, Object>> getpart2();

    @Select("select name, value from part3 limit 10")
    List<Map<String, Object>> getpart3();

    @Select("select name, value from part4")
    List<Map<String, Object>> getpart4();

    @Select("select name, value from part5")
    List<Map<String, Object>> getpart5();

    @Select("select name, value from part6 order by name")
    List<Map<String, Object>> getpart6();

    @Select("select name, value from part7")
    List<Map<String, Object>> getpart7();
}
