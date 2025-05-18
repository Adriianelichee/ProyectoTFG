package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.PurchasedService;
import com.adri.proyectotfg.Domain.Repository.PurchasedServiceRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.PurchasedServiceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PurchasedServiceRepositoryImpl implements PurchasedServiceRepository {
    private final PurchasedServiceJpaRepository jpa;

    @Override
    public PurchasedService save(PurchasedService ps) {
        return jpa.save(ps);
    }

    @Override
    public Optional<PurchasedService> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<PurchasedService> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }

    @Override
    public List<PurchasedService> findByCompanyId(Integer companyId) {
        return jpa.findByCompanyCompanyId(companyId);
    }
}