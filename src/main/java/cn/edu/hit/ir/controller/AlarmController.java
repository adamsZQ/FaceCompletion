package cn.edu.hit.ir.controller;

import cn.edu.hit.ir.BaseResponse;
import cn.edu.hit.ir.Data;
import cn.edu.hit.ir.entity.AlarmInfo;
import cn.edu.hit.ir.service.IAlarmInfoService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/alarmController")
public class AlarmController {

    private Gson gson = new Gson();

    @Resource
    private IAlarmInfoService alarmInfoService;

    @RequestMapping(value="/callToPolice")
    public void callToPolice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String content = request.getParameter("content");
        String tel = request.getParameter("tel");
        Float longitude = Float.parseFloat(request.getParameter("longitude"));
        Float latitude = Float.parseFloat(request.getParameter("latitude"));
        String img_name = request.getParameter("img_name");

        //TODO 存入数据库
        AlarmInfo alarmInfo = new AlarmInfo();
        alarmInfo.setContent(content);
        alarmInfo.setUserId(user_id);
        alarmInfo.setTel(tel);
        alarmInfo.setLongitude(longitude);
        alarmInfo.setLatitude(latitude);
        alarmInfo.setImgName(img_name);
        alarmInfoService.insert(alarmInfo);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("200");
        baseResponse.setData(new Data("success", "no reason"));

        response.getWriter().write(gson.toJson(baseResponse));
    }

    @RequestMapping(value="/getPoliceInfo")
    public void getPoliceInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int user_id = Integer.parseInt(request.getParameter("user_id"));

        AlarmInfo alarmInfo = alarmInfoService.selectByPrimaryKey(user_id);

        response.getWriter().write(gson.toJson(alarmInfo));
    }
}
