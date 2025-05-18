package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.PurchasedService;
import com.adri.proyectotfg.Domain.Entity.Report;
import com.adri.proyectotfg.Domain.Repository.PurchasedServiceRepository;
import com.adri.proyectotfg.Domain.Repository.ReportRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.PurchasedServiceJpaRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.ReportJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ReportRepositoryImpl implements ReportRepository {
    private final ReportJpaRepository jpa;

    @Override
    public Report save(Report report) {
        return jpa.save(report);
    }

    @Override
    public Optional<Report> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Report> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }

    @Override
    public List<Report> findByFloorId(Integer floorId) {
        return jpa.findByFloorFloorId(floorId);
    }
}
