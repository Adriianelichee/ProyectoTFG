package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.Reservation;
import com.adri.proyectotfg.Domain.Entity.ReservationStatus;
import com.adri.proyectotfg.Domain.Repository.ReservationRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.ReservationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ReservationRepositoryImpl implements ReservationRepository {
    private final ReservationJpaRepository jpa;

    @Override
    public Reservation save(Reservation reservation) {
        return jpa.save(reservation);
    }

    @Override
    public Optional<Reservation> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }

    @Override
    public List<Reservation> findByUserId(Integer userId) {
        return jpa.findByUserUserId(userId);
    }

    @Override
    public List<Reservation> findByStatus(ReservationStatus status) {
        return jpa.findByStatus(status);
    }
}