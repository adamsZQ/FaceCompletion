package cn.edu.hit.ir.controller;


import javax.servlet.http.HttpServletRequest;

import cn.edu.hit.ir.BaseResponse;
import cn.edu.hit.ir.Data;
import cn.edu.hit.ir.entity.User;
import cn.edu.hit.ir.service.IMenuService;
import cn.edu.hit.ir.service.IUserService;
import cn.edu.hit.ir.utils.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.util.*;

/**
 * @author zchai
 * @since 1.0 2018/3/26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private IMenuService menuService;

    private Gson gson = new Gson();

//    @RequestMapping(value="/showUser",method= RequestMethod.POST)
//    @ResponseBody
//    public User selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        Integer userId = Integer.valueOf(request.getParameter("id"));
//        User user = this.userService.selectUser(userId);
//        return user;
//    }
//
//    @RequestMapping("/queryUserByRobot")
//    public void queryUserByRobotId(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        Integer robotId = Integer.valueOf(request.getParameter("id"));
//        User user = this.userService.selectUserByRobotId(robotId);
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(user));
//        response.getWriter().close();
//    }
//
//    @RequestMapping(value="/addUser",method= RequestMethod.POST)
//    public String addUser(HttpServletRequest request, HttpServletResponse response){
//        return "";
//    }

    /**
     * 登录
     */
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String phone = request.getParameter("tel");
        String password = request.getParameter("password");
        //String vercode = request.getParameter("vercode").toLowerCase();
        //String verkey = request.getParameter("verkey");
        System.out.println("login方法被调用"+"accout:"+phone+";password:"+password+"");


        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("500");
        if (StringUtil.isBlank(phone,password)) {
            System.out.println("请输入完整信息");
            baseResponse.setData(new Data("failure", "请输入完整信息"));
            response.getWriter().write(gson.toJson(baseResponse));
            response.getWriter().close();
        }
//        if(!CaptchaUtil.isVerified(verkey, vercode, request)){
//            System.out.println("验证码错误");
//            baseResponse.setData(new Data("failure", "验证码错误"));
//            response.getWriter().write(gson.toJson(baseResponse));
//            response.getWriter().close();
//        }
        Map<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        List<User> loginUsers = userService.select(map);
        if (loginUsers.size() == 0) {
            System.out.println("账号不存在");
            baseResponse.setData(new Data("failure", "账号不存在"));

            response.getWriter().write(gson.toJson(baseResponse));
            response.getWriter().close();
        }else {
            System.out.println(loginUsers);
        }
        User loginUser = loginUsers.get(0);
        //String encryPsw = EndecryptUtils.encrytMd5(password, loginUser.getName(), 3);
        if (!loginUser.getPassword().equals(password)) {
            System.out.println("密码错误"+" 真正的密码："+loginUser.getPassword()+"获取到的密码："+password);
            baseResponse.setData(new Data("failure", "密码错误"));
            response.getWriter().write(gson.toJson(baseResponse));
            response.getWriter().close();
        }
        //String token = SubjectUtil.getInstance().createToken(loginUser.getUserId(), DateUtil.getAppointDate(new Date(), 30));
        loginUser.setPassword(null);
        System.out.println("登录成功");

        baseResponse.setStatus("200");
        baseResponse.setData(new Data("success", "no reason"));

        response.getWriter().write(gson.toJson(baseResponse));
        response.getWriter().close();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String phone = request.getParameter("tel");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        user.setName(userName);

        userService.addUser(user);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("200");
        baseResponse.setData(new Data("success", "no reason"));

        System.out.println(gson.toJson(baseResponse));
        response.getWriter().write(gson.toJson(baseResponse));
    }

//    /**
//     * 菜单
//     */
//    @RequestMapping(value="/menu",method= RequestMethod.POST)
//    public void menu(HttpServletRequest request, HttpServletResponse response)throws IOException{
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        System.out.println("菜单加载成功");
//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(menuService.selectAll()));
//        response.getWriter().close();
//    }

}
