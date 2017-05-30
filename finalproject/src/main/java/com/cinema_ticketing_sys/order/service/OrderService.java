package com.cinema_ticketing_sys.order.service;

import com.cinema_ticketing_sys.order.entity.Order;

/**
 * Created by huitianrui on 2017/5/30.
 */
public interface OrderService {

    /**
     * 存储新订单
     * @param order
     */
    void saveNewOrder(Order order);
}
