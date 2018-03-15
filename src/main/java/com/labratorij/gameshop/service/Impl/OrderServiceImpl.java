package com.labratorij.gameshop.service.Impl;

import com.labratorij.gameshop.entity.OrderEntity;
import com.labratorij.gameshop.repository.OrderRepository;
import com.labratorij.gameshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void add(OrderEntity client) {
        orderRepository.saveAndFlush(client);
    }

    public void edit(OrderEntity order_temp, int id) {
        OrderEntity order = orderRepository.getOne(id);
        order.setDate(order_temp.getDate());
        order.setEmployee(order_temp.getEmployee());
        order.setClient(order_temp.getClient());
        order.setVideogames(order_temp.getVideogames());
        orderRepository.save(order);
    }

    public void delete(int id) {
        orderRepository.delete(id);
    }

    public OrderEntity get(int id) {
        return orderRepository.getOne(id);
    }

    public List<OrderEntity> getAll() {
        return orderRepository.findAll();
    }
}
