package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.ReportProvider;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportProviderInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportProviderOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportProviderMapper {
    ReportProviderMapper INSTANCE = Mappers.getMapper(ReportProviderMapper.class);

    ReportProvider toEntity(ReportProviderInDto dto);

    ReportProviderOutDto toDto(ReportProvider entity);
}