package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.Cleaning;
import com.adri.proyectotfg.Domain.Entity.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CleaningJpaRepository extends JpaRepository<Cleaning, Integer> {
    List<Cleaning> findByFloorFloorId(Integer floorId);
}