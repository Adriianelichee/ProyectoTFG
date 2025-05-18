package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.Cleaning;
import com.adri.proyectotfg.Domain.Entity.Workstation;
import com.adri.proyectotfg.Infrastructure.Dto.In.CleaningInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.WorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CleaningOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.WorkstationOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UserMapper.class, RoomMapper.class, WorkstationMapper.class, FloorMapper.class})
public interface CleaningMapper {
    CleaningMapper INSTANCE = Mappers.getMapper(CleaningMapper.class);

    @Mapping(source = "userId", target = "user.userId")
    @Mapping(source = "roomId", target = "room.roomId")
    @Mapping(source = "workstationId", target = "workstation.workstationId")
    @Mapping(source = "floorId", target = "floor.floorId")
    Cleaning toEntity(CleaningInDto dto);

    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "room.roomId", target = "roomId")
    @Mapping(source = "workstation.workstationId", target = "workstationId")
    @Mapping(source = "floor.floorId", target = "floorId")
    CleaningOutDto toDto(Cleaning entity);
}