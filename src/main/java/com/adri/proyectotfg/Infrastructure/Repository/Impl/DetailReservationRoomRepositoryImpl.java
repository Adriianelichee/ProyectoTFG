package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.DetailReservationRoom;
import com.adri.proyectotfg.Domain.Repository.DetailReservationRoomRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.DetailReservationRoomJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class DetailReservationRoomRepositoryImpl implements DetailReservationRoomRepository {
    private final DetailReservationRoomJpaRepository jpa;

    @Override
    public DetailReservationRoom save(DetailReservationRoom detail) {
        return jpa.save(detail);
    }

    @Override
    public Optional<DetailReservationRoom> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<DetailReservationRoom> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}