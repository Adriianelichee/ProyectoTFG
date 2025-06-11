package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.DetailReservationRoom;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DetailReservationRoomRepository {
    DetailReservationRoom save(DetailReservationRoom detail);
    Optional<DetailReservationRoom> findById(Integer id);
    List<DetailReservationRoom> findAll();
    void deleteById(Integer id);
    List<DetailReservationRoom> findActiveReservationDetails(LocalDateTime now);
    List<DetailReservationRoom> findActiveReservationDetailsByRoom(Integer roomId, LocalDateTime now);
    List<DetailReservationRoom> findActiveReservationDetailsBetweenDates(LocalDateTime start, LocalDateTime end);
    DetailReservationRoom findByReservationId(Integer reservationId);
}