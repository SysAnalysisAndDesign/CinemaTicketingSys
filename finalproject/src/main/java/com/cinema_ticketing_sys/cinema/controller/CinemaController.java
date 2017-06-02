package com.cinema_ticketing_sys.cinema.controller;

import com.cinema_ticketing_sys.cinema.entity.Cinema;
import com.cinema_ticketing_sys.cinema.service.CinemaService;
import com.cinema_ticketing_sys.support.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huitianrui on 2017/5/23.
 */
@Controller
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping()
    public String getAllCinemas(Integer pageNo, Integer pageSize, ModelMap modelMap) {
        List<Cinema> cinemas = new ArrayList<>();
        cinemas = cinemaService.findCinemaByPage(pageNo, pageSize);
        long totalCinemas = cinemaService.findCinemaCount(Cinema.class);

        Page<Cinema> cinemaPage = new Page<>();
        cinemaPage.setList(cinemas);
        cinemaPage.setCurrPage(pageNo);
        cinemaPage.setPageSize(pageSize);
        cinemaPage.setTotalCount((int)totalCinemas);
        cinemaPage.setTotalPage((int)Math.ceil((double) totalCinemas / pageSize));

        // ModelMap用来存储Controller处理后的数据
        // Controller将ModelMap发送到前端供JSP页面使用
        modelMap.addAttribute("cinemaPage", cinemaPage);
        return "allCinemas";
    }

    @RequestMapping(value = "/{cinemaId}")
    public String cinemaDetails(@PathVariable String cinemaId, ModelMap modelMap) {
        Cinema cinema = cinemaService.findCinemaById(Integer.parseInt(cinemaId));
        modelMap.addAttribute("cinema", cinema);
        return "cinemaDetails";
    }

}