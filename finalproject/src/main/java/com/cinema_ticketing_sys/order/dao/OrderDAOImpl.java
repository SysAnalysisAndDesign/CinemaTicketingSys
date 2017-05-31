package com.cinema_ticketing_sys.order.dao;

import com.cinema_ticketing_sys.order.entity.Order;
import com.cinema_ticketing_sys.support.base.BaseDAOImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by huitianrui on 2017/5/30.
 */
@Repository
public class OrderDAOImpl extends BaseDAOImpl<Order> implements OrderDAO {

    @Override
    protected Class<Order> getEntityClass() {
        return Order.class;
    }

    @Override
    public void saveOrder(Order order) {
        save(order);
    }
}
