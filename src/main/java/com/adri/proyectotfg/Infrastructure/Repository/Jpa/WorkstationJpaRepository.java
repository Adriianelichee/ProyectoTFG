package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.User;
import com.adri.proyectotfg.Domain.Entity.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkstationJpaRepository extends JpaRepository<Workstation, Integer> {
    List<Workstation> findByFloorFloorId(Integer floorId);
}