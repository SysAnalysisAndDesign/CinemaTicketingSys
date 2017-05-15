package com.cinema_ticketing_sys.auth.controller;

import com.cinema_ticketing_sys.user.callback.UserRegisterCallback;
import com.cinema_ticketing_sys.user.entity.User;
import com.cinema_ticketing_sys.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huitianrui on 2017/5/13.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    static Logger logger = Logger.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String registerForm() {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(HttpServletRequest request) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("username", request.getParameter("username"));
        userInfo.put("password", request.getParameter("password"));
        userInfo.put("balance", 0);
        userInfo.put("portrait", null);
        userInfo.put("email", request.getParameter("email"));
        userInfo.put("phone_number", request.getParameter("phone_number"));
        userInfo.put("enable", false);
        userService.register(userInfo, new UserRegisterCallback() {
            @Override
            public void onRegisterFail(String msg) {
                logger.error(msg);
            }

            @Override
            public void onRegisterSucceed(User user) {
                logger.info("用户[" + user.getUserName() + "]注册成功！");
            }
        });
        return "redirect:/login";
    }
}
