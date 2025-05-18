package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.Payment;
import com.adri.proyectotfg.Domain.Entity.Reservation;
import com.adri.proyectotfg.Domain.Entity.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationJpaRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserUserId(Integer userId);
    List<Reservation> findByStatus(ReservationStatus status);
}