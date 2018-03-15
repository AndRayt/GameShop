package com.labratorij.gameshop.service;

import com.labratorij.gameshop.entity.PlatformEntity;

import java.util.List;

public interface PlatformService {
    void add(PlatformEntity client);
    void edit(PlatformEntity platfrom, int id);
    void delete(int id);
    PlatformEntity get(int id);
    List<PlatformEntity> getAll();
}
