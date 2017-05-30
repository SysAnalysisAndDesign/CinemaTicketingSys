package com.cinema_ticketing_sys.movie.dao;

import com.cinema_ticketing_sys.movie.entity.Movie;
import com.cinema_ticketing_sys.support.base.BaseDAOImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by KC on 2017/5/17.
 */
@Repository
public class MovieDAOImpl extends BaseDAOImpl<Movie> implements MovieDAO {
    @Override
    public Movie findMovieById(int id) {
        return get(id);
    }

    @Override
    public Movie findMovieByName(String name) {
        return findByUnique("cinemaName", name);
    }

    @Override
    public List<Movie> findMovieByPage(Integer pageNo, Integer pageSize) {
        return findByPage(pageNo, pageSize);
    }

    @Override
    public long findMovieCount(Class<Movie> movieClass) {
        return findCount(movieClass);
    }

    @Override
    protected Class<Movie> getEntityClass() {
        return Movie.class;
    }
}
