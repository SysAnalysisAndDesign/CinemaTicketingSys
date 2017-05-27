package com.cinema_ticketing_sys.movie.dao;

import com.cinema_ticketing_sys.movie.entity.Movie;
import com.cinema_ticketing_sys.support.base.BaseDAOImpl;

/**
 * Created by KC on 2017/5/17.
 */
public class MovieDAOImpl extends BaseDAOImpl<Movie> implements MovieDAO {
    @Override
    public Movie findMoiveById(int id) {
        return findByUnique("cinemaId", id);
    }

    @Override
    public Movie findMovieByName(String name) {
        return findByUnique("cinemaName", name);
    }

    @Override
    protected Class<Movie> getEntityClass() {
        return Movie.class;
    }
}
