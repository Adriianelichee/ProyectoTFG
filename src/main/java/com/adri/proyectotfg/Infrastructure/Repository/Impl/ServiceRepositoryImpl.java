package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.Reservation;
import com.adri.proyectotfg.Domain.Entity.ReservationStatus;
import com.adri.proyectotfg.Domain.Entity.Service;
import com.adri.proyectotfg.Domain.Repository.ReservationRepository;
import com.adri.proyectotfg.Domain.Repository.ServiceRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.ReservationJpaRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.ServiceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ServiceRepositoryImpl implements ServiceRepository {
    private final ServiceJpaRepository jpa;

    @Override
    public Service save(Service service) {
        return jpa.save(service);
    }

    @Override
    public Optional<Service> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Service> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}
