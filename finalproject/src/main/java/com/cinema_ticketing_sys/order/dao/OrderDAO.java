package com.cinema_ticketing_sys.order.dao;

import com.cinema_ticketing_sys.order.entity.Order;

/**
 * Created by huitianrui on 2017/5/14.
 */
public interface OrderDAO {

    /**
     * 存储订单
     * @param order
     */
    void saveOrder(Order order);
}
