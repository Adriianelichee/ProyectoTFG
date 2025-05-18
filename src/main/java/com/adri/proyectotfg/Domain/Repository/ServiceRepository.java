package com.adri.proyectotfg.Domain.Repository;

import com.adri.proyectotfg.Domain.Entity.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    Service save(Service service);
    Optional<Service> findById(Integer id);
    List<Service> findAll();
    void deleteById(Integer id);
}
