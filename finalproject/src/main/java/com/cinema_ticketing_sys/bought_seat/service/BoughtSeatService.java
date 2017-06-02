package com.cinema_ticketing_sys.bought_seat.service;

import com.cinema_ticketing_sys.bought_seat.entity.BoughtSeat;
import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;

/**
 * Created by huitianrui on 2017/5/29.
 */
public interface BoughtSeatService {

    /**
     * 创建新的已购买座位
     * @param seatId
     * @param row
     * @param col
     * @param cutting
     * @return
     */
    void createNewBoughtSeat(int seatId, Integer row, Integer col, MovieCutting cutting);
}
