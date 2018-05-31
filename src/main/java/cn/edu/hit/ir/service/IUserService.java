package cn.edu.hit.ir.service;

import cn.edu.hit.ir.entity.User;

/**
 * @author 袁明琛
 * @since 1.0 2018/3/20
 */


public interface IUserService {

    public User selectUser(Integer userId);
    public User selectUserByRobotId(Integer robotId);
    public void addUser(User user);
    public void deleteUser(Integer userId);
    public void updateUser(User user);

}