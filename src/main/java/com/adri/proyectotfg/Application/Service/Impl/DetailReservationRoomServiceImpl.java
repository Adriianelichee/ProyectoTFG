package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.DetailReservationRoomMapper;
import com.adri.proyectotfg.Application.Mapper.ReservationMapper;
import com.adri.proyectotfg.Application.Service.DetailReservationRoomService;
import com.adri.proyectotfg.Application.Service.ReservationService;
import com.adri.proyectotfg.Domain.Entity.DetailReservationRoom;
import com.adri.proyectotfg.Domain.Entity.Reservation;
import com.adri.proyectotfg.Domain.Entity.ReservationStatus;
import com.adri.proyectotfg.Domain.Repository.DetailReservationRoomRepository;
import com.adri.proyectotfg.Domain.Repository.ReservationRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.DetailReservationRoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReservationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.DetailReservationRoomOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReservationOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}