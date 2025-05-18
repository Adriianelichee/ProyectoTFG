package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.Company;
import com.adri.proyectotfg.Domain.Entity.ReportProvider;

import java.util.List;
import java.util.Optional;

public interface ReportProviderRepository {
    ReportProvider save(ReportProvider provider);
    Optional<ReportProvider> findById(Integer id);
    List<ReportProvider> findAll();
    void deleteById(Integer id);
}