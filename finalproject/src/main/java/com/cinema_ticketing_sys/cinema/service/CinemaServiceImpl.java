package com.cinema_ticketing_sys.cinema.service;

import com.cinema_ticketing_sys.cinema.dao.CinemaDAO;
import com.cinema_ticketing_sys.cinema.entity.Cinema;
import com.cinema_ticketing_sys.support.interfaces.CreationCallback;
import com.cinema_ticketing_sys.support.utils.NumUtils;
import com.cinema_ticketing_sys.support.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by KC on 2017/5/15.
 */
@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {
    @Autowired
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

    @Override
    public boolean checkCinemaInfo(String cinemaName, String address, String description, int rate , CreationCallback<Cinema> callback) {
        if(StringUtils.isNullOrEmpty(cinemaName) || StringUtils.isNullOrEmpty(address) ||
                StringUtils.isNullOrEmpty(description) || NumUtils.intIsNegative(rate)) {
            callback.createFail("电影院信息不完整或不合法！");
            return false;
        } else if (cinemaDAO.findCinemaByName(cinemaName) != null) {
            callback.createFail("该名字电影院已存在");
            return false;
        }
        return true;
    }

    @Override
    public List<Cinema> findCinemaByPage(Integer pageNo, Integer pageSize) {
        return cinemaDAO.findCinemaByPage(pageNo, pageSize);
    }

    @Override
    public long findCinemaCount(Class<Cinema> cinemaClass) {
        return cinemaDAO.findCinemaCount(cinemaClass);
    }

}
