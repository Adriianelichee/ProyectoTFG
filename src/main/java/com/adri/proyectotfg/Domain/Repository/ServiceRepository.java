package com.adri.proyectotfg.Domain.Repository;

import com.adri.proyectotfg.Domain.Entity.Services;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    Services save(Services services);
    Optional<Services> findById(Integer id);
    List<Services> findAll();
    void deleteById(Integer id);
}
