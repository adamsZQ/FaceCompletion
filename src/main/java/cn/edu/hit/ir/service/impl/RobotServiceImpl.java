package cn.edu.hit.ir.service.impl;

import cn.edu.hit.ir.dao.RobotMapper;
import cn.edu.hit.ir.entity.Robot;
import cn.edu.hit.ir.service.IRobotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/15
 */
@Service("robotService")
public class RobotServiceImpl implements IRobotService{

    @Resource
    private RobotMapper robotMapper;

    @Override
    public List<Robot> getAllRobotsByUserId(Integer userId) {
        List<Robot> robots = robotMapper.queryRobotsByUserId(userId);
        return robots;
    }

    @Override
    public void addRobot(Robot robot) {
        robotMapper.insertSelective(robot);
    }

    @Override
    public void deleteRobot(Integer robotId) {
        robotMapper.deleteByPrimaryKey(robotId);
    }

    @Override
    public Robot getRobot(Integer robotId) {
        return robotMapper.selectByPrimaryKey(robotId);
    }

    @Override
    public void updateRobot(Robot robot) {
        robotMapper.updateByPrimaryKeySelective(robot);
    }
}
