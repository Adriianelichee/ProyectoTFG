package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.DetailReservationWorkstationMapper;
import com.adri.proyectotfg.Application.Service.DetailReservationWorkstationService;
import com.adri.proyectotfg.Domain.Entity.DetailReservationWorkstation;
import com.adri.proyectotfg.Domain.Repository.DetailReservationWorkstationRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.DetailReservationWorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.DetailReservationWorkstationOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetailReservationWorkstationServiceImpl implements DetailReservationWorkstationService {
    private final DetailReservationWorkstationRepository repository;
    private final DetailReservationWorkstationMapper mapper;

    @Override
    public DetailReservationWorkstationOutDto createDetail(DetailReservationWorkstationInDto dto) {
        DetailReservationWorkstation d = mapper.toEntity(dto);
        return mapper.toDto(repository.save(d));
    }

    @Override
    public DetailReservationWorkstationOutDto getDetailById(Integer id) {
        DetailReservationWorkstation d = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detail not found: " + id));
        return mapper.toDto(d);
    }

    @Override
    public List<DetailReservationWorkstationOutDto> getAllDetails() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DetailReservationWorkstationOutDto updateDetail(Integer id, DetailReservationWorkstationInDto dto) {
        DetailReservationWorkstation d = mapper.toEntity(dto);
        d.setDetailId(id);
        return mapper.toDto(repository.save(d));
    }

    @Override
    public void deleteDetail(Integer id) {
        repository.deleteById(id);
    }


    @Override
    public List<DetailReservationWorkstationOutDto> getDetailsByWorkstation(Integer workstationId) {
        return repository.findByWorkstationWorkstationId(workstationId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DetailReservationWorkstationOutDto> getOccupiedWorkstationDetailsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return repository.findActiveReservationDetailsBetweenDates(start, end).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
public DetailReservationWorkstationOutDto getDetailsByReservation(Integer reservationId) {
    DetailReservationWorkstation detail = repository.findByReservationReservationId(reservationId);
    if (detail == null) {
        throw new RuntimeException("Detail not found for reservation: " + reservationId);
    }
    return mapper.toDto(detail);
}

}