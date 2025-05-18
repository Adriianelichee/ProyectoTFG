package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.Workstation;
import com.adri.proyectotfg.Infrastructure.Dto.In.WorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.WorkstationOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {FloorMapper.class})
public interface WorkstationMapper {
    WorkstationMapper INSTANCE = Mappers.getMapper(WorkstationMapper.class);

    @Mapping(source = "floorId", target = "floor.floorId")
    Workstation toEntity(WorkstationInDto dto);

    @Mapping(source = "floor.floorId", target = "floorId")
    WorkstationOutDto toDto(Workstation entity);
}