package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import java.util.List;
import java.util.Optional;

import com.adri.proyectotfg.Domain.Entity.Floor;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.FloorJpaRepository;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import com.adri.proyectotfg.Domain.Repository.*;

@RequiredArgsConstructor
@Repository
public class FloorRepositoryImpl implements FloorRepository {
    private final FloorJpaRepository jpa;

    @Override
    public Floor save(Floor floor) {
        return jpa.save(floor);
    }

    @Override
    public Optional<Floor> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Floor> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}
