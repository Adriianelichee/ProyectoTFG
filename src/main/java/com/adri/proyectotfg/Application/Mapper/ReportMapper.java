package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.Report;
import com.adri.proyectotfg.Domain.Entity.ReportProvider;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportProviderInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportProviderOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UserMapper.class, WorkstationMapper.class, RoomMapper.class, FloorMapper.class})
public interface ReportMapper {
    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    @Mapping(source = "userId", target = "user.userId")
    @Mapping(source = "workstationId", target = "workstation.workstationId")
    @Mapping(source = "roomId", target = "room.roomId")
    @Mapping(source = "floorId", target = "floor.floorId")
    Report toEntity(ReportInDto dto);

    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "workstation.workstationId", target = "workstationId")
    @Mapping(source = "room.roomId", target = "roomId")
    @Mapping(source = "floor.floorId", target = "floorId")
    ReportOutDto toDto(Report entity);
}