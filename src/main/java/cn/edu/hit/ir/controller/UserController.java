package cn.edu.hit.ir.controller;


import javax.servlet.http.HttpServletRequest;

import cn.edu.hit.ir.entity.User;
import cn.edu.hit.ir.service.IMenuService;
import cn.edu.hit.ir.service.IUserService;
import cn.edu.hit.ir.utils.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangfan.endecrypt.utils.EndecryptUtils;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author 袁明琛
 * @since 1.0 2018/3/26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private IMenuService menuService;

    @RequestMapping(value="/showUser",method= RequestMethod.POST)
    @ResponseBody
    public User selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Integer userId = Integer.valueOf(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        return user;
    }

    @RequestMapping("/queryUserByRobot")
    public void queryUserByRobotId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Integer robotId = Integer.valueOf(request.getParameter("id"));
        User user = this.userService.selectUserByRobotId(robotId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

    @RequestMapping(value="/addUser",method= RequestMethod.POST)
    public String addUser(HttpServletRequest request, HttpServletResponse response){
        return "";
    }

    /**
     * 登录
     */
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String vercode = request.getParameter("vercode").toLowerCase();
        String verkey = request.getParameter("verkey");
        System.out.println("login方法被调用"+"accout:"+account+";password:"+password+";vercode:"+vercode);

        if (StringUtil.isBlank(account,password,vercode,verkey)) {
            System.out.println("请输入完整信息");
            response.getWriter().write("请输入完整信息");
            response.getWriter().close();
        }
        if(!CaptchaUtil.isVerified(verkey, vercode, request)){
            System.out.println("验证码错误");
            response.getWriter().write("验证码错误");
            response.getWriter().close();
        }
        User loginUser = userService.selectUser(Integer.valueOf(account));
        if (loginUser == null) {
            System.out.println("账号不存在");
            response.getWriter().write("账号不存在");
            response.getWriter().close();
        }else {
            System.out.println(loginUser);
        }
        //String encryPsw = EndecryptUtils.encrytMd5(password, loginUser.getName(), 3);
        if (!loginUser.getPassword().equals(password)) {
            System.out.println("密码错误"+" 真正的密码："+loginUser.getPassword()+"获取到的密码："+password);
            response.getWriter().write("密码错误");
            response.getWriter().close();
        }
        //String token = SubjectUtil.getInstance().createToken(loginUser.getUserId(), DateUtil.getAppointDate(new Date(), 30));
        loginUser.setPassword(null);
        System.out.println("登录成功");
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(loginUser));
        response.getWriter().close();
    }

    /**
     * 菜单
     */
    @RequestMapping(value="/menu",method= RequestMethod.POST)
    public void menu(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("菜单加载成功");
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(menuService.selectAll()));
        response.getWriter().close();
    }

}
