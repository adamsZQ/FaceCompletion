package cn.edu.hit.ir.dao;

import cn.edu.hit.ir.entity.Robot;

import java.util.List;
import java.util.Map;

public interface RobotMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Robot record);

    int insertSelective(Robot record);

    Robot selectByPrimaryKey(Integer id);

    List<Robot> select(Map<String,Object> map);

    List<Robot> queryRobotsByUserId(Integer userId);

    int updateByPrimaryKeySelective(Robot record);

    int updateByPrimaryKey(Robot record);
}