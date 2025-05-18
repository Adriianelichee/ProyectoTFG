package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.RoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.RoomOutDto;

import java.util.List;

public interface RoomService {
    RoomOutDto createRoom(RoomInDto dto);
    RoomOutDto getRoomById(Integer id);
    List<RoomOutDto> getAllRooms();
    List<RoomOutDto> getRoomsByFloor(Integer floorId);
    RoomOutDto updateRoom(Integer id, RoomInDto dto);
    void deleteRoom(Integer id);
}