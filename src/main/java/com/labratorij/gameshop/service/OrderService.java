package com.labratorij.gameshop.service;

import com.labratorij.gameshop.entity.OrderEntity;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    void add(OrderEntity client);
    void edit(OrderEntity order, int id);
    void delete(int id);
    OrderEntity get(int id);
    List<OrderEntity> getAll();
    void save(OrderEntity order);
    void addVideogameList(int id_game, int id_order);
    void changeDate(int id, Date date);
}
