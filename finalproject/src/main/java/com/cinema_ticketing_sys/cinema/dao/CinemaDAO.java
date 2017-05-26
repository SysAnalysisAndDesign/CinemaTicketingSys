package com.cinema_ticketing_sys.cinema.dao;

import com.cinema_ticketing_sys.cinema.entity.Cinema;

import java.util.List;

/**
 * Created by KC on 2017/5/15.
 */
public interface CinemaDAO {
    /**
     * 通过id查询电影院
     *
     * @param id 电影院对应id
     * @return 该影院实体
     */
    Cinema findCinemaById(int id);

    /**
     * 根据影院名字查询电影院
     *
     * @param name 影院名字
     * @return 影院实体
     */
    Cinema findCinemaByName(String name);

    /**
     *根据评分查询电影院
     * @param rate 分数查询
     * @return 系列影院
     */
    List<Cinema> findCinemaByRate(int rate);
    /**
     * 更新影院内容
     *
     * @param cinema 被更新后的电影院
     *
     */
    void saveOrUpdateCinema(Cinema cinema);

}
