package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.Room;
import com.adri.proyectotfg.Infrastructure.Dto.In.RoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.RoomOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {FloorMapper.class})
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(source = "floorId", target = "floor.floorId")
    Room toEntity(RoomInDto dto);

    @Mapping(source = "floor.floorId", target = "floorId")
    RoomOutDto toDto(Room entity);
}
