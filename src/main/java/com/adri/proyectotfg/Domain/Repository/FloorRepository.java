package com.adri.proyectotfg.Domain.Repository;

import com.adri.proyectotfg.Domain.Entity.Floor;

import java.util.List;
import java.util.Optional;

public interface FloorRepository {
    Floor save(Floor floor);
    Optional<Floor> findById(Integer id);
    List<Floor> findAll();
    void deleteById(Integer id);
    List<Floor> getFloorsByCompanyId(Integer companyId);
}