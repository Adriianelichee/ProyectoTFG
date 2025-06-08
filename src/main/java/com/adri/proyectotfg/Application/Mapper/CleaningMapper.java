package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.*;
import com.adri.proyectotfg.Domain.Repository.FloorRepository;
import com.adri.proyectotfg.Domain.Repository.RoomRepository;
import com.adri.proyectotfg.Domain.Repository.UserRepository;
import com.adri.proyectotfg.Domain.Repository.WorkstationRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.CleaningInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CleaningOutDto;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {UserMapper.class, RoomMapper.class, WorkstationMapper.class, FloorMapper.class})
public abstract class CleaningMapper {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private WorkstationRepository workstationRepository;

    @Autowired
    private FloorRepository floorRepository;

    @Mapping(source = "userId", target = "user", qualifiedByName = "userIdToUser")
    @Mapping(source = "roomId", target = "room", qualifiedByName = "roomIdToRoom")
    @Mapping(source = "workstationId", target = "workstation", qualifiedByName = "workstationIdToWorkstation")
    @Mapping(source = "floorId", target = "floor", qualifiedByName = "floorIdToFloor")
    public abstract Cleaning toEntity(CleaningInDto dto);

    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "room.roomId", target = "roomId")
    @Mapping(source = "workstation.workstationId", target = "workstationId")
    @Mapping(source = "floor.floorId", target = "floorId")
    public abstract CleaningOutDto toDto(Cleaning entity);

    @Named("userIdToUser")
    protected User userIdToUser(Integer userId) {
        if (userId == null) return null;
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con ID: " + userId));
    }

    @Named("roomIdToRoom")
    protected Room roomIdToRoom(Integer roomId) {
        if (roomId == null) return null;
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Sala no encontrada con ID: " + roomId));
    }

    @Named("workstationIdToWorkstation")
    protected Workstation workstationIdToWorkstation(Integer workstationId) {
        if (workstationId == null) return null;
        return workstationRepository.findById(workstationId)
                .orElseThrow(() -> new EntityNotFoundException("Puesto de trabajo no encontrado con ID: " + workstationId));
    }

    @Named("floorIdToFloor")
    protected Floor floorIdToFloor(Integer floorId) {
        if (floorId == null) return null;
        return floorRepository.findById(floorId)
                .orElseThrow(() -> new EntityNotFoundException("Piso no encontrado con ID: " + floorId));
    }
}