package com.cinema_ticketing_sys.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Lenovo on 2017/5/11.
 */
@Controller //注解：采⽤注解的⽅式，可以明确地定义该类为处理请求的Controller类；
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    //注解：⽤于定义⼀个请求映射，value为请求的url，值为 / 说明，该请求⾸⻚请求，method⽤以指定该请求类型，⼀般为get和post；
    public String index() {
        return "index";
        //处理完该请求后返回的⻚⾯，此请求返回 index.jsp⻚⾯。
    }
}
