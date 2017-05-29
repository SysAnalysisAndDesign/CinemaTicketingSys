package com.cinema_ticketing_sys.bought_seat.dao;

import com.cinema_ticketing_sys.bought_seat.entity.BoughtSeat;
import com.cinema_ticketing_sys.support.base.BaseDAOImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by huitianrui on 2017/5/29.
 */
@Repository
public class BoughtSeatDAOImpl extends BaseDAOImpl<BoughtSeat> implements BoughtSeatDAO {

    @Override
    protected Class<BoughtSeat> getEntityClass() {
        return BoughtSeat.class;
    }

    @Override
    public void saveBoughtSeat(BoughtSeat boughtSeat) {
        save(boughtSeat);
    }

}
