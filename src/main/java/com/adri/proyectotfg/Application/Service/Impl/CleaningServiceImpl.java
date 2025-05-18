package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.CleaningMapper;
import com.adri.proyectotfg.Application.Mapper.WorkstationMapper;
import com.adri.proyectotfg.Application.Service.CleaningService;
import com.adri.proyectotfg.Application.Service.WorkstationService;
import com.adri.proyectotfg.Domain.Entity.Cleaning;
import com.adri.proyectotfg.Domain.Entity.Workstation;
import com.adri.proyectotfg.Domain.Repository.CleaningRepository;
import com.adri.proyectotfg.Domain.Repository.WorkstationRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.CleaningInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.WorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CleaningOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.WorkstationOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CleaningServiceImpl implements CleaningService {
    private final CleaningRepository repository;
    private final CleaningMapper mapper;

    @Override
    public CleaningOutDto createCleaning(CleaningInDto dto) {
        Cleaning c = mapper.toEntity(dto);
        return mapper.toDto(repository.save(c));
    }

    @Override
    public CleaningOutDto getCleaningById(Integer id) {
        Cleaning c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cleaning not found: " + id));
        return mapper.toDto(c);
    }

    @Override
    public List<CleaningOutDto> getAllCleanings() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CleaningOutDto> getCleaningsByFloor(Integer floorId) {
        return repository.findByFloorId(floorId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CleaningOutDto updateCleaning(Integer id, CleaningInDto dto) {
        Cleaning c = mapper.toEntity(dto);
        c.setCleaningId(id);
        return mapper.toDto(repository.save(c));
    }

    @Override
    public void deleteCleaning(Integer id) {
        repository.deleteById(id);
    }
}