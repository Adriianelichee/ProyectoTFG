package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.PurchasedService;
import com.adri.proyectotfg.Domain.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasedServiceJpaRepository extends JpaRepository<PurchasedService, Integer> {
    List<PurchasedService> findByCompanyCompanyId(Integer companyId);
}