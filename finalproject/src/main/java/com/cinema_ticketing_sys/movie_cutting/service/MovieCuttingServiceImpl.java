package com.cinema_ticketing_sys.movie_cutting.service;

import com.cinema_ticketing_sys.movie_cutting.dao.MovieCuttingsDAO;
import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by huitianrui on 2017/5/28.
 */
@Service
@Transactional
public class MovieCuttingServiceImpl implements MovieCuttingService {

    @Autowired
    private MovieCuttingsDAO movieCuttingsDAO;

    @Override
    public MovieCutting findCuttingById(int cuttingId) {
        return movieCuttingsDAO.findCuttingById(cuttingId);
    }
}
