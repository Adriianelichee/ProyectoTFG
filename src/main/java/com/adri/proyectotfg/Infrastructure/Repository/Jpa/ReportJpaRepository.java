package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportJpaRepository extends JpaRepository<Report, Integer> {
    List<Report> findByFloorFloorId(Integer floorId);
    List<Report> findByUserUserId(Integer userId);
}