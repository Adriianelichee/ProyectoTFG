package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.DetailReservationRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DetailReservationRoomJpaRepository extends JpaRepository<DetailReservationRoom, Integer> {
    @Query("SELECT d FROM DetailReservationRoom d " +
            "JOIN d.reservation r " +
            "WHERE r.status <> 'CANCELLED' " +
            "AND d.endTime > :now " +
            "ORDER BY d.startTime")
    List<DetailReservationRoom> findActiveReservationDetails(@Param("now") LocalDateTime now);

    @Query("SELECT d FROM DetailReservationRoom d " +
            "JOIN d.reservation r " +
            "WHERE r.status <> 'CANCELLED' " +
            "AND d.room.roomId = :roomId " +
            "AND d.endTime > :now " +
            "ORDER BY d.startTime")
    List<DetailReservationRoom> findActiveReservationDetailsByRoom(@Param("roomId") Integer roomId, @Param("now") LocalDateTime now);

    @Query("SELECT d FROM DetailReservationRoom d " +
            "JOIN d.reservation r " +
            "WHERE r.status <> 'CANCELLED' " +
            "AND d.startTime >= :start " +
            "AND d.endTime <= :end " +
            "ORDER BY d.startTime")
    List<DetailReservationRoom> findActiveReservationDetailsBetweenDates(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end);

    @Query("SELECT d FROM DetailReservationRoom d WHERE d.reservation.reservationId = :reservationId")
    DetailReservationRoom findByReservationId(@Param("reservationId") Integer reservationId);


}
