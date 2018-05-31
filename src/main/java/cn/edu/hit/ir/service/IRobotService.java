package cn.edu.hit.ir.service;

import cn.edu.hit.ir.entity.Robot;

import java.util.List;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/15
 */
public interface IRobotService {
    public List<Robot> getAllRobotsByUserId(Integer userId);
    public void addRobot(Robot robot);
    public void deleteRobot(Integer robotId);
    public Robot getRobot(Integer robotId);
    public void updateRobot(Robot robot);
}
