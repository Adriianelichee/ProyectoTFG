package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.Floor;
import com.adri.proyectotfg.Domain.Repository.FloorRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.FloorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Floor> getFloorsByCompanyId(Integer companyId) {
        return jpa.findByCompanyId(companyId);
    }
}
