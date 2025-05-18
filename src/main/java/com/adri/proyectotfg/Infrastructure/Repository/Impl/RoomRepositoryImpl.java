package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.Room;
import com.adri.proyectotfg.Domain.Repository.RoomRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.RoomJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class RoomRepositoryImpl implements RoomRepository {
    private final RoomJpaRepository jpa;

    @Override
    public Room save(Room room) {
        return jpa.save(room);
    }

    @Override
    public Optional<Room> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<Room> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }

    @Override
    public List<Room> findByFloorId(Integer floorId) {
        return jpa.findByFloorFloorId(floorId);
    }
}