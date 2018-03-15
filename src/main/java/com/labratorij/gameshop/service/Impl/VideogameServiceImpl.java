package com.labratorij.gameshop.service.Impl;

import com.labratorij.gameshop.entity.VideogameEntity;
import com.labratorij.gameshop.repository.VideogameRepository;
import com.labratorij.gameshop.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideogameServiceImpl implements VideogameService {
    @Autowired
    private VideogameRepository videogameRepository;

    public void add(VideogameEntity client) {
        videogameRepository.saveAndFlush(client);
    }

    public void edit(VideogameEntity videogame_temp, int id) {
        VideogameEntity videogame = videogameRepository.getOne(id);
        videogame.setDeveloper(videogame_temp.getDeveloper());
        videogame.setPublisher(videogame_temp.getPublisher());
        videogame.setGenre(videogame_temp.getGenre());
        videogame.setAgeRating(videogame_temp.getAgeRating());
        videogame.setDate(videogame_temp.getDate());
        videogame.setCostOfPurchase(videogame_temp.getCostOfPurchase());
        videogame.setPrice(videogame_temp.getPrice());
        videogame.setQuantity(videogame_temp.getQuantity());
        videogame.setVideogame(videogame_temp.getVideogame());
        videogame.setOrders(videogame_temp.getOrders());
        videogame.setPlatfrom(videogame_temp.getPlatfrom());
        videogameRepository.save(videogame);
    }

    public void delete(int id) {
        videogameRepository.delete(id);
    }

    public VideogameEntity get(int id) {
        return videogameRepository.getOne(id);
    }

    public List<VideogameEntity> getAll() {
        return videogameRepository.findAll();
    }
}
