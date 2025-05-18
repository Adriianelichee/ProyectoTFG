package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.Services;
import com.adri.proyectotfg.Infrastructure.Dto.In.ServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ServiceOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    Services toEntity(ServiceInDto dto);

    ServiceOutDto toDto(Services entity);
}