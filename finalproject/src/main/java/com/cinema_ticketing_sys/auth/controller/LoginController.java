package com.cinema_ticketing_sys.auth.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huitianrui on 2017/5/13.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping()
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login.do")
    public String loginSucceed(ModelMap model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        System.out.println(userDetails.getUsername());
        return "index";
    }
}
