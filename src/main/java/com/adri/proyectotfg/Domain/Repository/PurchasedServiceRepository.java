package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.PurchasedService;

import java.util.List;
import java.util.Optional;

public interface PurchasedServiceRepository {
    PurchasedService save(PurchasedService purchasedService);
    Optional<PurchasedService> findById(Integer id);
    List<PurchasedService> findAll();
    void deleteById(Integer id);
    List<PurchasedService> findByCompanyId(Integer companyId);
}