package com.labratorij.gameshop.service.Impl;

import com.labratorij.gameshop.entity.OrderEntity;
import com.labratorij.gameshop.entity.PlatformEntity;
import com.labratorij.gameshop.entity.VideogameEntity;
import com.labratorij.gameshop.repository.OrderRepository;
import com.labratorij.gameshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.labratorij.gameshop.repository.VideogameRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private VideogameRepository videogameRepository;

    public void add(OrderEntity client) {
        orderRepository.saveAndFlush(client);
    }

    public void edit(OrderEntity order_temp, int id) {
        OrderEntity order = orderRepository.findOne(id);
        order.setDate(order_temp.getDate());
        order.setEmployee(order_temp.getEmployee());
        order.setClient(order_temp.getClient());
        orderRepository.save(order);
    }

    public void save(OrderEntity order) {
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

    public void addVideogameList(int id_game, int id_platform) {
        OrderEntity pt = orderRepository.findOne(id_platform);
        HashSet rl = new HashSet(pt.getVideogames());
        rl.add(videogameRepository.findOne(id_game));
        pt.setVideogames(new ArrayList<VideogameEntity>(rl));
        orderRepository.save(pt);
    }
}
