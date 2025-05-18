package com.adri.proyectotfg.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.adri.proyectotfg.Domain.Entity.Floor;

public interface FloorRepository {
    Floor save(Floor floor);
    Optional<Floor> findById(Integer id);
    List<Floor> findAll();
    void deleteById(Integer id);
}