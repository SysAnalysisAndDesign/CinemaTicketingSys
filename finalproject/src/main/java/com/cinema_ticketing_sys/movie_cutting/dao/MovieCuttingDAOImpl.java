package com.cinema_ticketing_sys.movie_cutting.dao;

import com.cinema_ticketing_sys.movie_cutting.entity.MovieCutting;
import com.cinema_ticketing_sys.support.base.BaseDAOImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by huitianrui on 2017/5/28.
 */
@Repository
public class MovieCuttingDAOImpl extends BaseDAOImpl<MovieCutting> implements MovieCuttingsDAO {

    @Override
    protected Class<MovieCutting> getEntityClass() { return MovieCutting.class; }

    @Override
    public MovieCutting findCuttingById(int id) { return get(id); }
}
