package cn.edu.hit.ir.controller;

import cn.edu.hit.ir.entity.WantedOrder;
import cn.edu.hit.ir.service.IWantedOrderService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/wanted")
public class WantedOrderController {

    @Resource
    private IWantedOrderService wantedOrderService;

    private Gson gson = new Gson();

    @RequestMapping(value = "insertWantedOrder")
    public void insertWantedOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String info = request.getParameter("info");
        String detail = request.getParameter("detail");
        String datetime = request.getParameter("datetime");
        String number = request.getParameter("number");
        String imgName = request.getParameter("imgName");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        WantedOrder wantedOrder = new WantedOrder();
        wantedOrder.setDetail(detail);
        wantedOrder.setImgName(imgName);
        wantedOrder.setNumber(number);
        wantedOrder.setInfo(info);
        wantedOrder.setDatetime(formatter.parse(datetime));

        wantedOrderService.insertSelective(wantedOrder);

        response.getWriter().write("success");
    }

    @RequestMapping(value = "getAllWantedOrder")
    public void getAllWantedOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<WantedOrder> wantedOrderList = wantedOrderService.selectAll();

        response.getWriter().write(gson.toJson(wantedOrderList));

    }
}
