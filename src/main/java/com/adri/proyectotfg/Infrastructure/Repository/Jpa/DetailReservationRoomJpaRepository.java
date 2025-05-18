package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.DetailReservationRoom;
import com.adri.proyectotfg.Domain.Entity.PurchasedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailReservationRoomJpaRepository extends JpaRepository<DetailReservationRoom, Integer> {}
