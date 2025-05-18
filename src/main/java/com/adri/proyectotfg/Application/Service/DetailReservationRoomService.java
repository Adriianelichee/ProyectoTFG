package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.DetailReservationRoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReservationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.DetailReservationRoomOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReservationOutDto;

import java.util.List;

public interface DetailReservationRoomService {
    DetailReservationRoomOutDto createDetail(DetailReservationRoomInDto dto);
    DetailReservationRoomOutDto getDetailById(Integer id);
    List<DetailReservationRoomOutDto> getAllDetails();
    DetailReservationRoomOutDto updateDetail(Integer id, DetailReservationRoomInDto dto);
    void deleteDetail(Integer id);
}