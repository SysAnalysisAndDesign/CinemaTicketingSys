package com.cinema_ticketing_sys.movie.controller;

import com.cinema_ticketing_sys.movie.entity.Movie;
import com.cinema_ticketing_sys.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huitianrui on 2017/5/28.
 */
@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/{movieId}")
    public String movieDetails(@PathVariable String movieId, ModelMap modelMap) {
        Movie movie = movieService.findMovieById(Integer.parseInt(movieId));
        modelMap.addAttribute("movie", movie);
        return "movieDetails";
    }
}
