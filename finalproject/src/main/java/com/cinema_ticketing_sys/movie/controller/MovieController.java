package com.cinema_ticketing_sys.movie.controller;

import com.cinema_ticketing_sys.cinema.entity.Cinema;
import com.cinema_ticketing_sys.movie.entity.Movie;
import com.cinema_ticketing_sys.movie.service.MovieService;
import com.cinema_ticketing_sys.support.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huitianrui on 2017/5/28.
 */
@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping()
    public String getAllCinemas(Integer pageNo, Integer pageSize, ModelMap modelMap) {
        List<Cinema> cinemas = new ArrayList<>();
        cinemas = movieService.findMovieByName(name);
        long totalCinemas = cinemaService.findCinemaCount(Cinema.class);

        Page<Cinema> moviePage = new Page<>();
        moviePage.setList(cinemas);
        moviePage.setCurrPage(pageNo);
        moviePage.setPageSize(pageSize);
        moviePage.setTotalCount((int)totalCinemas);
        moviePage.setTotalPage((int)Math.ceil((double) totalCinemas / pageSize));

        // ModelMap用来存储Controller处理后的数据
        // Controller将ModelMap发送到前端供JSP页面使用
        modelMap.addAttribute("moviePage", moviePage);
        return "allMovies";
    }

    @RequestMapping(value = "/{movieId}")
    public String movieDetails(@PathVariable String movieId, ModelMap modelMap) {
        Movie movie = movieService.findMovieById(Integer.parseInt(movieId));
        modelMap.addAttribute("movie", movie);
        return "movieDetails";
    }
}
