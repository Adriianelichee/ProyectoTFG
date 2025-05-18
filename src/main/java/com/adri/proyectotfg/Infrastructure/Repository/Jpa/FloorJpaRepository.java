package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorJpaRepository extends JpaRepository<Floor, Integer> {}
