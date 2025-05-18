package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.RoomMapper;
import com.adri.proyectotfg.Application.Service.RoomService;
import com.adri.proyectotfg.Domain.Entity.Room;
import com.adri.proyectotfg.Domain.Repository.RoomRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.RoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.RoomOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public RoomOutDto createRoom(RoomInDto dto) {
        Room room = roomMapper.toEntity(dto);
        return roomMapper.toDto(roomRepository.save(room));
    }

    @Override
    public RoomOutDto getRoomById(Integer id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found: " + id));
        return roomMapper.toDto(room);
    }

    @Override
    public List<RoomOutDto> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(roomMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomOutDto> getRoomsByFloor(Integer floorId) {
        return roomRepository.findByFloorId(floorId).stream()
                .map(roomMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoomOutDto updateRoom(Integer id, RoomInDto dto) {
        Room room = roomMapper.toEntity(dto);
        room.setRoomId(id);
        return roomMapper.toDto(roomRepository.save(room));
    }

    @Override
    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }
}