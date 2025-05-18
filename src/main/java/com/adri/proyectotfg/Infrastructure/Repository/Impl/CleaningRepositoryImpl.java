package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.Cleaning;
import com.adri.proyectotfg.Domain.Entity.Workstation;
import com.adri.proyectotfg.Domain.Repository.CleaningRepository;
import com.adri.proyectotfg.Domain.Repository.WorkstationRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.CleaningJpaRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.WorkstationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CleaningRepositoryImpl implements CleaningRepository {
    private final CleaningJpaRepository jpa;

    @Override
    public Cleaning save(Cleaning cleaning) {
        return jpa.save(cleaning);
    }

    @Override
    public Optional<Cleaning> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Cleaning> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }

    @Override
    public List<Cleaning> findByFloorId(Integer floorId) {
        return jpa.findByFloorFloorId(floorId);
    }
}