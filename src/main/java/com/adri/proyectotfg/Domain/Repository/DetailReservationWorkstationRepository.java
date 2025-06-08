package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.DetailReservationWorkstation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DetailReservationWorkstationRepository {
    DetailReservationWorkstation save(DetailReservationWorkstation detail);

    Optional<DetailReservationWorkstation> findById(Integer id);

    List<DetailReservationWorkstation> findAll();

    void deleteById(Integer id);

    List<DetailReservationWorkstation> findActiveReservationDetailsBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

    List<DetailReservationWorkstation> findByWorkstationWorkstationId(Integer workstationId);

}