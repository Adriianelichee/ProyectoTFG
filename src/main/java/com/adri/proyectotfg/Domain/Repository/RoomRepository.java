package com.adri.proyectotfg.Domain.Repository;

import com.adri.proyectotfg.Domain.Entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    Room save(Room room);
    Optional<Room> findById(Integer id);
    List<Room> findAll();
    void deleteById(Integer id);
    List<Room> findByFloorId(Integer floorId);
}