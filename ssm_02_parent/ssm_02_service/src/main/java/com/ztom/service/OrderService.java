package com.ztom.service;

import com.ztom.domain.Order;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/31 16:48
 */
public interface OrderService {
    /**
     * 查询全部订单
     * @return
     */
    List<Order> findAll();

    /**
     * 添加订单
     * @param order
     */
    void save(Order order);
}
