package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Company save(Company company);
    Optional<Company> findById(Integer id);
    List<Company> findAll();
    void deleteById(Integer id);
    Optional<Company> findByContactEmail(String email);
}