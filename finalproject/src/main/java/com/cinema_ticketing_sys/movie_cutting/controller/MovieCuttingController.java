package com.cinema_ticketing_sys.movie_cutting.controller;

import com.cinema_ticketing_sys.cinema.entity.Cinema;
import com.cinema_ticketing_sys.movie.entity.Movie;
import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;
import com.cinema_ticketing_sys.movie_cutting.service.MovieCuttingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huitianrui on 2017/5/28.
 */
@Controller
@RequestMapping("/cuttings")
public class MovieCuttingController {

    @Autowired
    private MovieCuttingService movieCuttingService;

    @RequestMapping(value = "/{cuttingId}")
    public String cuttingDetail(@PathVariable String cuttingId, ModelMap modelMap) {
        MovieCutting movieCutting = movieCuttingService.findCuttingById(Integer.parseInt(cuttingId));
        Movie movie = movieCutting.getMovie();
        Cinema cinema = movie.getCinema();
        modelMap.addAttribute("cutting", movieCutting);
        modelMap.addAttribute("movie", movie);
        modelMap.addAttribute("cinema", cinema);
        return "chooseSeat";
    }
}
