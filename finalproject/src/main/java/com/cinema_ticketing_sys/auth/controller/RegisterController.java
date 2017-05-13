package com.cinema_ticketing_sys.auth.controller;

import com.cinema_ticketing_sys.user.callback.UserRegisterCallback;
import com.cinema_ticketing_sys.user.entity.User;
import com.cinema_ticketing_sys.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("")
    public String register() {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("username", "huitr");
        userInfo.put("password", "123456");
        userInfo.put("balance", 0);
        userInfo.put("portrait", null);
        userInfo.put("email", "huitianrui@gmail.com");
        userInfo.put("phone", "123456");
        userInfo.put("enable", (byte) 1);
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
        userService.deleteUserById(2);
        return "login";
    }
}
