package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.Cleaning;

import java.util.List;
import java.util.Optional;

public interface CleaningRepository {
    Cleaning save(Cleaning cleaning);
    Optional<Cleaning> findById(Integer id);
    List<Cleaning> findAll();
    void deleteById(Integer id);
    List<Cleaning> findByFloorId(Integer floorId);
}