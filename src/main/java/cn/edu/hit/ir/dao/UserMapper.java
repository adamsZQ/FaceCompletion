package cn.edu.hit.ir.dao;

import cn.edu.hit.ir.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> select(Map<String,Object> map);

    User queryUserByRobotId(Integer robotId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}