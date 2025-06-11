package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.DetailReservationRoomMapper;
import com.adri.proyectotfg.Application.Service.DetailReservationRoomService;
import com.adri.proyectotfg.Domain.Entity.DetailReservationRoom;
import com.adri.proyectotfg.Domain.Repository.DetailReservationRoomRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.DetailReservationRoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.DetailReservationRoomOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetailReservationRoomServiceImpl implements DetailReservationRoomService {
    private final DetailReservationRoomRepository repository;
    private final DetailReservationRoomMapper mapper;

    @Override
    public DetailReservationRoomOutDto createDetail(DetailReservationRoomInDto dto) {
        DetailReservationRoom d = mapper.toEntity(dto);
        return mapper.toDto(repository.save(d));
    }

    @Override
    public DetailReservationRoomOutDto getDetailByReservationId(Integer id) {
        DetailReservationRoom detail = repository.findByReservationId(id);
        if (detail == null) {
            throw new RuntimeException("Detalle de reserva no encontrado para la reserva: " + id);
        }
        return mapper.toDto(detail);
    }

    @Override
    public DetailReservationRoomOutDto getDetailById(Integer id) {
        DetailReservationRoom d = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detail not found: " + id));
        return mapper.toDto(d);
    }

    @Override
    public List<DetailReservationRoomOutDto> getAllDetails() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DetailReservationRoomOutDto updateDetail(Integer id, DetailReservationRoomInDto dto) {
        DetailReservationRoom d = mapper.toEntity(dto);
        d.setDetailId(id);
        return mapper.toDto(repository.save(d));
    }

    @Override
    public void deleteDetail(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<DetailReservationRoomOutDto> getOccupiedRoomDetails() {
        return repository.findActiveReservationDetails(LocalDateTime.now()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DetailReservationRoomOutDto> getOccupiedRoomDetailsByRoom(Integer roomId) {
        return repository.findActiveReservationDetailsByRoom(roomId, LocalDateTime.now()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DetailReservationRoomOutDto> getOccupiedRoomDetailsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return repository.findActiveReservationDetailsBetweenDates(start, end).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}