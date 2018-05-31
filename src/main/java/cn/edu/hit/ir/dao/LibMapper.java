package cn.edu.hit.ir.dao;

import cn.edu.hit.ir.entity.Lib;

import java.util.List;
import java.util.Map;

public interface LibMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Lib record);

    int insertSelective(Lib record);

    Lib selectByPrimaryKey(Integer id);

    List<Lib> select(Map<String,Object> map);

    List<Lib> queryLibsByRobotId(Integer robotId);

    int updateByPrimaryKeySelective(Lib record);

    int updateByPrimaryKey(Lib record);
}