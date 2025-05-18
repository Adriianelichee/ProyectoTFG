package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.DetailReservationWorkstation;
import com.adri.proyectotfg.Domain.Repository.DetailReservationWorkstationRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.DetailReservationWorkstationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class DetailReservationWorkstationRepositoryImpl implements DetailReservationWorkstationRepository {
    private final DetailReservationWorkstationJpaRepository jpa;

    @Override
    public DetailReservationWorkstation save(DetailReservationWorkstation detail) {
        return jpa.save(detail);
    }

    @Override
    public Optional<DetailReservationWorkstation> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<DetailReservationWorkstation> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }
}