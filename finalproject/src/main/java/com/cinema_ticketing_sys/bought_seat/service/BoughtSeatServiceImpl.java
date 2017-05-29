package com.cinema_ticketing_sys.bought_seat.service;

import com.cinema_ticketing_sys.bought_seat.dao.BoughtSeatDAO;
import com.cinema_ticketing_sys.bought_seat.entity.BoughtSeat;
import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huitianrui on 2017/5/29.
 */
@Service
@Transactional
public class BoughtSeatServiceImpl implements BoughtSeatService {

    @Autowired
    private BoughtSeatDAO boughtSeatDAO;

    @Override
    public void createNewBoughtSeat(int seatId, Integer row, Integer col, MovieCutting cutting) {
        BoughtSeat boughtSeat = new BoughtSeat();
        boughtSeat.setSeatId(seatId);
        boughtSeat.setRow(row);
        boughtSeat.setCol(col);
        boughtSeat.setMovieCutting(cutting);
        boughtSeatDAO.saveBoughtSeat(boughtSeat);
    }
}
