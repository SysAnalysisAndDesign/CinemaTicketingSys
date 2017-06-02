package com.cinema_ticketing_sys.movie_cutting.service;

import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;

/**
 * Created by huitianrui on 2017/5/28.
 */
public interface MovieCuttingService {

    /**
     * 通过id查询场次
     * @param cuttingId
     * @return
     */
    MovieCutting findCuttingById(int cuttingId);
}
