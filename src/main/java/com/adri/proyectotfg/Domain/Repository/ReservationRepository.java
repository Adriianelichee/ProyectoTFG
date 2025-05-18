package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.Reservation;
import com.adri.proyectotfg.Domain.Entity.ReservationStatus;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Reservation save(Reservation reservation);
    Optional<Reservation> findById(Integer id);
    List<Reservation> findAll();
    void deleteById(Integer id);
    List<Reservation> findByUserId(Integer userId);
    List<Reservation> findByStatus(ReservationStatus status);
}