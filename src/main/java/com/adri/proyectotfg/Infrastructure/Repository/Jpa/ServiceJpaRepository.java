package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.Reservation;
import com.adri.proyectotfg.Domain.Entity.ReservationStatus;
import com.adri.proyectotfg.Domain.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceJpaRepository extends JpaRepository<Service, Integer> {}
