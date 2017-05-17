package com.cinema_ticketing_sys.movie.dao;

import com.cinema_ticketing_sys.movie.entity.Movie;

/**
 * Created by KC on 2017/5/17.
 */
public interface MovieDAO {

    /**
     * 根据ID查找电影
     * @param id 电影对应数据库id
     * @return 对应电影实体
     */
    Movie findMoiveById(int id);

    /**
     * 根据电影名查找电影
     * @param name 电影名字 唯一
     * @return 返回电影实体
     */
    Movie findMovieByName(String name);

//    boolean checkMoiveInfo(String name, String description, double price)
}
