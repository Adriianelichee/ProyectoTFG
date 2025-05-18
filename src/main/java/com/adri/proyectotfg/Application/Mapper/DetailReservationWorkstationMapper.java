package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.DetailReservationWorkstation;
import com.adri.proyectotfg.Infrastructure.Dto.In.DetailReservationWorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.DetailReservationWorkstationOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ReservationMapper.class, WorkstationMapper.class})
public interface DetailReservationWorkstationMapper {
    DetailReservationWorkstationMapper INSTANCE = Mappers.getMapper(DetailReservationWorkstationMapper.class);

    @Mapping(source = "reservationId", target = "reservation.reservationId")
    @Mapping(source = "workstationId", target = "workstation.workstationId")
    DetailReservationWorkstation toEntity(DetailReservationWorkstationInDto dto);

    @Mapping(source = "reservation.reservationId", target = "reservationId")
    @Mapping(source = "workstation.workstationId", target = "workstationId")
    DetailReservationWorkstationOutDto toDto(DetailReservationWorkstation entity);
}