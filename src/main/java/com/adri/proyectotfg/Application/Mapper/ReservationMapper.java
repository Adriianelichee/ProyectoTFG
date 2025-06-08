package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.Reservation;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReservationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReservationOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(source = "userId", target = "user.userId")
    Reservation toEntity(ReservationInDto dto);

    @Mapping(source = "user.userId", target = "userId")
    ReservationOutDto toDto(Reservation entity);
}