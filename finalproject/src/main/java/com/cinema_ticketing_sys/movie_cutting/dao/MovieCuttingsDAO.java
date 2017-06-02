package com.cinema_ticketing_sys.movie_cutting.dao;

import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;

/**
 * Created by huitianrui on 2017/5/28.
 */
public interface MovieCuttingsDAO {

    /**
     * 通过id查询场次
     * @param id
     * @return
     */
    MovieCutting findCuttingById(int id);
}
