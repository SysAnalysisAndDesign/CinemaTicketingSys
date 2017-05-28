package com.cinema_ticketing_sys.movie.service;

import com.cinema_ticketing_sys.movie.entity.Movie;
import com.cinema_ticketing_sys.support.interfaces.CreationCallback;

/**
 * Created by Lenovo on 2017/5/17.
 */
public interface MovieService {

    /**
     * 通过id查询电影
     * @param movieId
     * @return 电影
     */
    Movie findMovieById(int movieId);

    /**
     * 通过名字查询电影
     * @param Name 电影名
     * @return 电影实体
     */
    Movie findMovieByName(String Name);

    /**
     * 确认电影信息是否完整
     * @param movieName 电影名
     * @param description 介绍
     * @param price 价格
     * @return 完整返回true，否则返回false
     */
    boolean checkMoiveInfo(String movieName, String description, double price, CreationCallback<Movie> callback);
}
