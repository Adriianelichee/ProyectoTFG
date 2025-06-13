package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.Report;
import com.adri.proyectotfg.Domain.Entity.ReportStatus;
import com.adri.proyectotfg.Domain.Repository.ReportRepository;
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

    @Override
    public Report updateStatus(Integer reportId, ReportStatus status) {
        Report report = jpa.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con id: " + reportId));
        report.setStatus(status);
        return jpa.save(report);
    }

    @Override
    public List<Report> findByUserId(Integer userId) {
        return jpa.findByUserUserId(userId);
    }


}
