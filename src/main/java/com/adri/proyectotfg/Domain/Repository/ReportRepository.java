package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.Report;

import java.util.List;
import java.util.Optional;

public interface ReportRepository {
    Report save(Report report);
    Optional<Report> findById(Integer id);
    List<Report> findAll();
    void deleteById(Integer id);
    List<Report> findByFloorId(Integer floorId);
}