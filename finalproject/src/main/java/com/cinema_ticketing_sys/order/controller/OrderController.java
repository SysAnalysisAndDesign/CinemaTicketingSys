package com.cinema_ticketing_sys.order.controller;

import com.cinema_ticketing_sys.order.entity.Order;
import com.cinema_ticketing_sys.order.service.OrderService;
import com.cinema_ticketing_sys.user.entity.User;
import com.cinema_ticketing_sys.user.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huitianrui on 2017/5/30.
 */
@Controller
@RequestMapping("/order.do")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping()
    public String saveNewOrder(HttpServletRequest request) {
        String newOrder = request.getParameter("newOrder");
        JSONArray newOrderList = JSONArray.fromObject(newOrder);
        JSONObject newOrderObj = newOrderList.getJSONObject(0);
        String date = newOrderObj.getString("date");
        String cinemaName = newOrderObj.getString("cinemaName");
        String movieName = newOrderObj.getString("movieName");
        String hallNumber = newOrderObj.getString("hallNumber");
        String totalPrice = newOrderObj.getString("totalPrice");

        Order order = new Order();
        order.setTotalPrice(totalPrice);
        order.setHallNumber(hallNumber);
        order.setMovieName(movieName);
        order.setCinemaName(cinemaName);
        order.setDate(date);
        // 这是瞎写的
        order.setRow(1);
        order.setCol(2);

        String currUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(currUserName);
        order.setUser(user);

        orderService.saveNewOrder(order);

        return "index";
    }
}
