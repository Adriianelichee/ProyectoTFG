package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.Workstation;

import java.util.List;
import java.util.Optional;

public interface WorkstationRepository {
    Workstation save(Workstation workstation);
    Optional<Workstation> findById(Integer id);
    List<Workstation> findAll();
    void deleteById(Integer id);
    List<Workstation> findByFloorId(Integer floorId);
}
