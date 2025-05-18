package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.DetailReservationRoom;
import com.adri.proyectotfg.Infrastructure.Dto.In.DetailReservationRoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.DetailReservationRoomOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ReservationMapper.class, RoomMapper.class})
public interface DetailReservationRoomMapper {
    DetailReservationRoomMapper INSTANCE = Mappers.getMapper(DetailReservationRoomMapper.class);

    @Mapping(source = "reservationId", target = "reservation.reservationId")
    @Mapping(source = "roomId", target = "room.roomId")
    DetailReservationRoom toEntity(DetailReservationRoomInDto dto);

    @Mapping(source = "reservation.reservationId", target = "reservationId")
    @Mapping(source = "room.roomId", target = "roomId")
    DetailReservationRoomOutDto toDto(DetailReservationRoom entity);
}