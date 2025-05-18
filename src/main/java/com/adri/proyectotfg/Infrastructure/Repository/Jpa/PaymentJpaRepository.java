package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.Cleaning;
import com.adri.proyectotfg.Domain.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentJpaRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByCompanyCompanyId(Integer companyId);
}