package com.cinema_ticketing_sys.cinema.service;

import com.cinema_ticketing_sys.cinema.entity.Cinema;
import com.cinema_ticketing_sys.support.interfaces.CreationCallback;

import java.util.List;

/**
 * Created by KC on 2017/5/15.
 */
public interface CinemaService {
    /**
     * 通过名字查找电影院
     * @param name 名字
     * @return 影院
     */
    Cinema findCinemaByName(String name);

    /**
     * 更新电影院分数
     * @param rate 更新后的分数
     * @param cinema 被更新的电影院
     */
    void updateCinemaRate(int rate, Cinema cinema);

    /**
     * 根据分数要求找出电影院，仅找出一个分数的所有影院
     * @param rate 分数
     * @return 分数为该分的影院
     */
    List<Cinema> findCinemaByRate(int rate);

    /**
     * 查询信息完整新和电影院名字的唯一性
     * @param cinemaName 影院名字
     * @param address 地址
     * @param description 介绍
     * @param rate 评分
     * @return 完整且不重复返回true，否则false，没有callback不会写（。
     */
    boolean checkCinemaInfo(String cinemaName, String address, String description, int rate, CreationCallback<Cinema> callback);
}
