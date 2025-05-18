package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.Services;
import com.adri.proyectotfg.Domain.Repository.ServiceRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.ServiceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ServiceRepositoryImpl implements ServiceRepository {
    private final ServiceJpaRepository jpa;

    @Override
    public Services save(Services services) {
        return jpa.save(services);
    }

    @Override
    public Optional<Services> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Services> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}
