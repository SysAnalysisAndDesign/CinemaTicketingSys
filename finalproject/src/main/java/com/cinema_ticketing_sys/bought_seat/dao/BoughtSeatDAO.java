package com.cinema_ticketing_sys.bought_seat.dao;

import com.cinema_ticketing_sys.bought_seat.entity.BoughtSeat;

/**
 * Created by huitianrui on 2017/5/29.
 */
public interface BoughtSeatDAO {

    /**
     * 将新座位存进数据库
     * @param boughtSeat
     */
    void saveBoughtSeat(BoughtSeat boughtSeat);
}
