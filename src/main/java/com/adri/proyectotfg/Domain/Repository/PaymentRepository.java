package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.Payment;
import com.adri.proyectotfg.Domain.Entity.PaymentStatus;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findById(Integer id);
    List<Payment> findAll();
    void deleteById(Integer id);
    List<Payment> findByCompanyId(Integer companyId);
    Payment updateStatus(Integer paymentId, PaymentStatus newStatus);
}