package com.cinema_ticketing_sys.cinema.service;

import com.cinema_ticketing_sys.cinema.entity.Cinema;

import java.util.List;

/**
 * Created by KC on 2017/5/15.
 */
public interface CinemaService {
    Cinema findCinemaByName(String name);

    void updateCinemaRate(int rate, Cinema cinema);

    List<Cinema> findCinemaByRate(int rate);
    
}
