package cn.edu.hit.ir.service;

import cn.edu.hit.ir.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author 袁明琛
 * @since 1.0 2018/3/20
 */


public interface IUserService {

    List<User> select(Map<String,Object> map);
    User selectUserByRobotId(Integer robotId);
    void addUser(User user);
    void deleteUser(Integer userId);
    void updateUser(User user);

}