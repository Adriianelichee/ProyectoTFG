package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.CleaningInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReservationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CleaningOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReservationOutDto;

import java.util.List;

public interface ReservationService {
    ReservationOutDto createReservation(ReservationInDto dto);
    ReservationOutDto getReservationById(Integer id);
    List<ReservationOutDto> getAllReservations();
    List<ReservationOutDto> getReservationsByUser(Integer userId);
    List<ReservationOutDto> getReservationsByStatus(String status);
    ReservationOutDto updateReservation(Integer id, ReservationInDto dto);
    void deleteReservation(Integer id);
}