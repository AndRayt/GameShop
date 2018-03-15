package com.labratorij.gameshop.service;

import com.labratorij.gameshop.entity.ClientEntity;

import java.util.List;

public interface ClientService {
    void add(ClientEntity client);
    void edit(ClientEntity client, int id);
    void delete(int id);
    ClientEntity get(int id);
    List<ClientEntity> getAll();
}
