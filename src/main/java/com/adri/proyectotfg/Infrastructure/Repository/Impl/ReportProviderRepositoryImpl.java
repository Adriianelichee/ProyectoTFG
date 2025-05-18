package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.ReportProvider;
import com.adri.proyectotfg.Domain.Repository.ReportProviderRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.ReportProviderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ReportProviderRepositoryImpl implements ReportProviderRepository {
    private final ReportProviderJpaRepository jpa;

    @Override
    public ReportProvider save(ReportProvider provider) {
        return jpa.save(provider);
    }

    @Override
    public Optional<ReportProvider> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<ReportProvider> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}