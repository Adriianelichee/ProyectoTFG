package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.Company;
import com.adri.proyectotfg.Domain.Entity.Room;
import com.adri.proyectotfg.Domain.Repository.CompanyRepository;
import com.adri.proyectotfg.Domain.Repository.RoomRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.CompanyJpaRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.RoomJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CompanyRepositoryImpl implements CompanyRepository {
    private final CompanyJpaRepository jpa;

    @Override
    public Company save(Company company) {
        return jpa.save(company);
    }

    @Override
    public Optional<Company> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Company> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }

    @Override
    public Optional<Company> findByContactEmail(String email) {
        return jpa.findByContactEmail(email);
    }
}