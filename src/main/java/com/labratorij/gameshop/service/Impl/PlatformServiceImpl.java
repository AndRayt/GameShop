package com.labratorij.gameshop.service.Impl;

import com.labratorij.gameshop.entity.PlatformEntity;
import com.labratorij.gameshop.entity.VideogameEntity;
import com.labratorij.gameshop.repository.PlatformRepository;
import com.labratorij.gameshop.repository.VideogameRepository;
import com.labratorij.gameshop.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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
        platformRepository.getOne(id).getVideogames().clear();

        platformRepository.delete(id);
    }

    public PlatformEntity get(int id) {
        return platformRepository.findOne(id);
    }

    public List<PlatformEntity> getAll() {
        return platformRepository.findAll();
    }

    public void addVideogameList(int id_game, int id_platform) {
        PlatformEntity pt = platformRepository.findOne(id_platform);
        HashSet rl = new HashSet(pt.getVideogames());
        rl.add(videogameRepository.findOne(id_game));
        pt.setVideogames(new ArrayList<VideogameEntity>(rl));
        platformRepository.save(pt);
    }
}
