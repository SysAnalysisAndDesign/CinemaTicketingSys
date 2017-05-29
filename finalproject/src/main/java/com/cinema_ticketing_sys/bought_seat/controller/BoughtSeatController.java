package com.cinema_ticketing_sys.bought_seat.controller;

import com.cinema_ticketing_sys.bought_seat.entity.BoughtSeat;
import com.cinema_ticketing_sys.bought_seat.service.BoughtSeatService;
import com.cinema_ticketing_sys.movie.entity.Movie;
import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;
import com.cinema_ticketing_sys.movie_cutting.service.MovieCuttingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huitianrui on 2017/5/29.
 */
@Controller
@RequestMapping("/cuttings")
@Transactional
public class BoughtSeatController {

    @Autowired
    private BoughtSeatService boughtSeatService;

    @Autowired
    private MovieCuttingService movieCuttingService;

    @RequestMapping(value = "/{cuttingId}/order")
    public String saveBoughtSeat(@PathVariable String cuttingId, HttpServletRequest request,
                                 ModelMap modelMap) {
        String rows = request.getParameter("rows");
        String cols = request.getParameter("cols");
        String tickets = request.getParameter("tickets");

        String[] rows_para = rows.split(",");
        String[] cols_para = cols.split(",");

        List<BoughtSeat> boughtSeats = new ArrayList<>();

        for (int i = 0; i < rows_para.length; i++) {
            MovieCutting movieCutting = movieCuttingService.findCuttingById(Integer.parseInt(cuttingId));
            BoughtSeat boughtSeat = new BoughtSeat();
            int seatId = (Integer.parseInt(rows_para[i]) - 1) * 10 + Integer.parseInt(cols_para[i]);
            int row = Integer.parseInt(rows_para[i]);
            int col = Integer.parseInt(cols_para[i]);
            boughtSeat.setRow(row);
            boughtSeat.setCol(col);
            boughtSeats.add(boughtSeat);
            boughtSeatService.createNewBoughtSeat(seatId, row, col, movieCutting);
        }

        MovieCutting updatedMovieCutting = movieCuttingService.findCuttingById(Integer.parseInt(cuttingId));
        Movie movie = updatedMovieCutting.getMovie();
        modelMap.addAttribute("movie", movie);
        modelMap.addAttribute("cutting", updatedMovieCutting);
        modelMap.addAttribute("tickets", tickets);
        double totalPrice = Integer.parseInt(tickets) * movie.getPrice();
        modelMap.addAttribute("totalPrice", totalPrice);
        modelMap.addAttribute("seats", boughtSeats);

        return "orderDetails";
    }

}
