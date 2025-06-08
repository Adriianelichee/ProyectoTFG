package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.DetailReservationWorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.DetailReservationWorkstationOutDto;

import java.time.LocalDateTime;
import java.util.List;

public interface DetailReservationWorkstationService {
    DetailReservationWorkstationOutDto createDetail(DetailReservationWorkstationInDto dto);
    DetailReservationWorkstationOutDto getDetailById(Integer id);
    List<DetailReservationWorkstationOutDto> getAllDetails();
    DetailReservationWorkstationOutDto updateDetail(Integer id, DetailReservationWorkstationInDto dto);
    void deleteDetail(Integer id);
    List<DetailReservationWorkstationOutDto> getDetailsByWorkstation(Integer workstationId);
    List<DetailReservationWorkstationOutDto> getOccupiedWorkstationDetailsBetweenDates(LocalDateTime start, LocalDateTime end);

}