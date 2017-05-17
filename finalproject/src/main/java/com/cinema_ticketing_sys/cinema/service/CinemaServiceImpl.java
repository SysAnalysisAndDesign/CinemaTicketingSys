package com.cinema_ticketing_sys.cinema.service;

import com.cinema_ticketing_sys.cinema.dao.CinemaDAO;
import com.cinema_ticketing_sys.cinema.entity.Cinema;

import java.util.List;

/**
 * Created by KC on 2017/5/15.
 */
public class CinemaServiceImpl implements CinemaService {
    private CinemaDAO cinemaDAO;

    @Override
    public Cinema findCinemaByName(String name) {
        return cinemaDAO.findCinemaByName(name);
    }

    @Override
    public void updateCinemaRate(int rate, Cinema cinema) {
        cinema.setRate(rate);
        cinemaDAO.saveOrUpdateCinema(cinema);
    }

    @Override
    public List<Cinema> findCinemaByRate(int rate) {
        return cinemaDAO.findCinemaByRate(rate);
    }


}
