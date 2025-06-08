package com.adri.proyectotfg.Infrastructure.Repository.Jpa;

import com.adri.proyectotfg.Domain.Entity.DetailReservationWorkstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DetailReservationWorkstationJpaRepository extends JpaRepository<DetailReservationWorkstation, Integer> {
    List<DetailReservationWorkstation> findByWorkstationWorkstationId(Integer workstationId);

    @Query("SELECT d FROM DetailReservationWorkstation d WHERE " +
            "((d.startTime <= :endDate) AND (d.endTime >= :startDate))")
    List<DetailReservationWorkstation> findActiveReservationDetailsBetweenDates(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);
}
