package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.DetailReservationRoom;

import java.util.List;
import java.util.Optional;

public interface DetailReservationRoomRepository {
    DetailReservationRoom save(DetailReservationRoom detail);
    Optional<DetailReservationRoom> findById(Integer id);
    List<DetailReservationRoom> findAll();
    void deleteById(Integer id);
}