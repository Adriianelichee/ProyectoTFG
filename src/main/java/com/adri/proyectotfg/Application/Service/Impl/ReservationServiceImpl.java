package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.ReservationMapper;
import com.adri.proyectotfg.Application.Service.ReservationService;
import com.adri.proyectotfg.Domain.Entity.Reservation;
import com.adri.proyectotfg.Domain.Entity.ReservationStatus;
import com.adri.proyectotfg.Domain.Repository.ReservationRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReservationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReservationOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository repository;
    private final ReservationMapper mapper;

    @Override
    public ReservationOutDto createReservation(ReservationInDto dto) {
        Reservation r = mapper.toEntity(dto);
        return mapper.toDto(repository.save(r));
    }

    @Override
    public ReservationOutDto getReservationById(Integer id) {
        Reservation r = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found: " + id));
        return mapper.toDto(r);
    }

    @Override
    public List<ReservationOutDto> getAllReservations() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationOutDto> getReservationsByUser(Integer userId) {
        return repository.findByUserId(userId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationOutDto> getReservationsByStatus(String status) {
        ReservationStatus st = ReservationStatus.valueOf(status);
        return repository.findByStatus(st).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationOutDto updateReservation(Integer id, ReservationInDto dto) {
        Reservation r = mapper.toEntity(dto);
        r.setReservationId(id);
        return mapper.toDto(repository.save(r));
    }

    @Override
    public void deleteReservation(Integer id) {
        repository.deleteById(id);
    }
}