package com.labratorij.gameshop.service;

import com.labratorij.gameshop.entity.VideogameEntity;

import java.util.List;

public interface VideogameService {
    void add(VideogameEntity client);
    void edit(VideogameEntity videogame, int id);
    void delete(int id);
    VideogameEntity get(int id);
    List<VideogameEntity> getAll();
}
