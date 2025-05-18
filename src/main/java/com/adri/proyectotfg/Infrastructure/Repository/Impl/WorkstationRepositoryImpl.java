package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.Workstation;
import com.adri.proyectotfg.Domain.Repository.WorkstationRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.WorkstationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class WorkstationRepositoryImpl implements WorkstationRepository {
    private final WorkstationJpaRepository jpa;

    @Override
    public Workstation save(Workstation ws) {
        return jpa.save(ws);
    }

    @Override
    public Optional<Workstation> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Workstation> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }

    @Override
    public List<Workstation> findByFloorId(Integer floorId) {
        return jpa.findByFloorFloorId(floorId);
    }
}