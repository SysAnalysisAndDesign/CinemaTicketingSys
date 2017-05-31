package com.cinema_ticketing_sys.order.service;

import com.cinema_ticketing_sys.order.dao.OrderDAO;
import com.cinema_ticketing_sys.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huitianrui on 2017/5/30.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public void saveNewOrder(Order order) {
        orderDAO.saveOrder(order);
    }
}
