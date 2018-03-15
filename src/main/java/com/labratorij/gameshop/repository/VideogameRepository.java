package com.labratorij.gameshop.repository;

import com.labratorij.gameshop.entity.VideogameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogameRepository extends JpaRepository<VideogameEntity, Integer> {
}
