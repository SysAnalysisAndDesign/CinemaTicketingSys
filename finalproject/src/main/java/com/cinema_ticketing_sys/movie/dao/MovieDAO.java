package com.cinema_ticketing_sys.movie.dao;

import com.cinema_ticketing_sys.cinema.entity.Cinema;
import com.cinema_ticketing_sys.movie.entity.Movie;

import java.util.List;

/**
 * Created by KC on 2017/5/17.
 */
public interface MovieDAO {

    /**
     * 根据ID查找电影
     * @param id 电影对应数据库id
     * @return 对应电影实体
     */
    Movie findMovieById(int id);

    /**
     * 根据电影名查找电影
     * @param name 电影名字 唯一
     * @return 返回电影实体
     */
    Movie findMovieByName(String name);

    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Movie> findMovieByPage(Integer pageNo, Integer pageSize);

    /**
     * 查询影院的总数
     * @param movieClass
     * @return
     */
    long findMovieCount(Class<Movie> movieClass);

}
