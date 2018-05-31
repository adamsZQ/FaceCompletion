package cn.edu.hit.ir.dao;

/**
 * @author 袁明琛
 * @since 1.0 2018/3/20
 */

import cn.edu.hit.ir.entity.Lib;
import cn.edu.hit.ir.entity.Robot;
import cn.edu.hit.ir.entity.User;
import com.mchange.v2.util.DoubleWeakHashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RobotMapper robotMapper;
    @Autowired
    private LibMapper libMapper;

    @Test
    public void testSelectUserByPrikey() throws Exception {
        Integer id = 1;
        User user = userMapper.selectByPrimaryKey(id);
        System.out.println(user.toString());
    }

    @Test
    public void testQueryUserByRobotId(){
        Integer id = 1;
        User user = userMapper.queryUserByRobotId(id);
        System.out.println(user.toString());
    }

    @Test
    public void testQueryRobotsByUserId(){
        Integer id = 1;
        List<Robot> robots= robotMapper.queryRobotsByUserId(id);
        for (int i = 0;i<robots.size();i++){
            Robot robot = robots.get(i);
            System.out.println(robot.toString());

        }
    }
    @Test
    public void testQueryLibsByRobotId(){
        Integer id = 1;
        List<Lib> libs = libMapper.queryLibsByRobotId(id);
        for (int i = 0; i < libs.size();i++){
            Lib lib = libs.get(i);
            System.out.println(lib.toString());
        }
    }

    @Test
    public void testSelectUser(){
        Integer id = 1;
        Map<String,Object> map = new HashMap();
        map.put("sex","男");
        List<User> users = userMapper.select(map);
        for (int i = 0; i < users.size();i++){
            User user = users.get(i);
            System.out.println(user.toString());
        }
    }

    @Test
    public void testSelectRobot(){
        Integer id = 1;
        Map<String,Object> map = new HashMap();
        //map.put("sex","男");
        map.put("userId",1);
        List<Robot> robots = robotMapper.select(map);
        for (int i = 0; i < robots.size();i++){
            Robot robot = robots.get(i);
            System.out.println(robot.toString());
        }
    }

    @Test
    public void testSelectLib(){
        Integer id = 1;
        Map<String,Object> map = new HashMap();
        //map.put("sex","男");
        map.put("robotId",1);
        List<Lib> libs = libMapper.select(map);
        for (int i = 0; i < libs.size();i++){
            Lib lib = libs.get(i);
            System.out.println(lib.toString());
        }
    }

}
