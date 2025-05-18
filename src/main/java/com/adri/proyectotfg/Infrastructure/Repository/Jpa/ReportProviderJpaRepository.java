package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.Company;
import com.adri.proyectotfg.Domain.Entity.ReportProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportProviderJpaRepository extends JpaRepository<ReportProvider, Integer> {}
