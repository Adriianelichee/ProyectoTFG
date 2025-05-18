package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.Floor;
import com.adri.proyectotfg.Infrastructure.Dto.In.FloorInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.FloorOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FloorMapper {
    FloorMapper INSTANCE = Mappers.getMapper(FloorMapper.class);

    Floor toEntity(FloorInDto dto);

    FloorOutDto toDto(Floor entity);
}