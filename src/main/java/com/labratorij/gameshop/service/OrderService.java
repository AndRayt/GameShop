package com.labratorij.gameshop.service;

import com.labratorij.gameshop.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    void add(OrderEntity client);
    void edit(OrderEntity order, int id);
    void delete(int id);
    OrderEntity get(int id);
    List<OrderEntity> getAll();
}
