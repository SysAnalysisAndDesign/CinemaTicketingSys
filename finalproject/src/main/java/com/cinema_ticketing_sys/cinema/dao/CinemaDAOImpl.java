package com.cinema_ticketing_sys.cinema.dao;

import com.cinema_ticketing_sys.cinema.dao.CinemaDAO;
import com.cinema_ticketing_sys.cinema.entity.Cinema;
import com.cinema_ticketing_sys.support.base.BaseDAOImpl;

import java.util.List;

/**
 * Created by KC on 2017/5/15.
 */
public class CinemaDAOImpl extends BaseDAOImpl<Cinema> implements CinemaDAO {
    @Override
    public Cinema findCinemaById(int id) {
        return findByUnique("cinemaId", id);
    }

    @Override
    public Cinema findCinemaByName(String name) {
        return findByUnique("cinemaName", name);
    }

    @Override
    public List<Cinema> findCinemaByRate(int rate) {
        return findBy("rate", rate);
    }

    @Override
    public void saveOrUpdateCinema(Cinema cinema) {
        save(cinema);
    }

    @Override
    protected Class<Cinema> getEntityClass() {
        return Cinema.class;
    }
}
