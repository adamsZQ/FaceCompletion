package cn.edu.hit.ir.service.impl;

import cn.edu.hit.ir.dao.UserMapper;
import cn.edu.hit.ir.entity.User;
import cn.edu.hit.ir.service.IUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @author 袁明琛
 * @since 1.0 2018/3/20
 */


@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    public User selectUser(Integer userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User selectUserByRobotId(Integer robotId) {
        return this.userMapper.queryUserByRobotId(robotId);
    }

    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

}
