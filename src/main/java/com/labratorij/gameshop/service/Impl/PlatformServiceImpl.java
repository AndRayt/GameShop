package com.labratorij.gameshop.service.Impl;

import com.labratorij.gameshop.entity.PlatformEntity;
import com.labratorij.gameshop.repository.PlatformRepository;
import com.labratorij.gameshop.repository.VideogameRepository;
import com.labratorij.gameshop.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {
    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private VideogameRepository videogameRepository;

    public void add(PlatformEntity client) {
        platformRepository.saveAndFlush(client);
    }

    public void edit(PlatformEntity platform_temp, int id) {
        PlatformEntity platform = platformRepository.getOne(id);
        platform.setProducer(platform_temp.getProducer());
        platform.setRelevance(platform_temp.getRelevance());
        platform.setPlatformcol(platform_temp.getPlatformcol());
        platform.setPlatform(platform_temp.getPlatform());
        platformRepository.save(platform);
    }

    public void delete(int id) {
        platformRepository.delete(id);
    }

    public PlatformEntity get(int id) {
        return platformRepository.getOne(id);
    }

    public List<PlatformEntity> getAll() {
        return platformRepository.findAll();
    }

    public void addVideogameList(int id_game, int id_platform) {
        PlatformEntity pt = platformRepository.findOne(id_platform);
        pt.addVideogame(videogameRepository.findOne(id_game));
        platformRepository.save(pt);
    }
}
