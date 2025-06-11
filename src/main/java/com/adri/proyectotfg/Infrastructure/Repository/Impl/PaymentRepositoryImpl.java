package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.Payment;
import com.adri.proyectotfg.Domain.Entity.PaymentStatus;
import com.adri.proyectotfg.Domain.Repository.PaymentRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
    private final PaymentJpaRepository jpa;

    @Override
    public Payment save(Payment payment) {
        return jpa.save(payment);
    }

    @Override
    public Optional<Payment> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Payment> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }

    @Override
    public List<Payment> findByCompanyId(Integer companyId) {
        return jpa.findByCompanyCompanyId(companyId);
    }

    @Override
    public Payment updateStatus(Integer paymentId, PaymentStatus newStatus) {
        Payment payment = jpa.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado con id: " + paymentId));
        payment.setPaymentStatus(newStatus);
        return jpa.save(payment);
    }

}