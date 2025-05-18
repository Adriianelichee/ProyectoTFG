package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.UserMapper;
import com.adri.proyectotfg.Application.Mapper.WorkstationMapper;
import com.adri.proyectotfg.Application.Service.UserService;
import com.adri.proyectotfg.Application.Service.WorkstationService;
import com.adri.proyectotfg.Domain.Entity.User;
import com.adri.proyectotfg.Domain.Entity.Workstation;
import com.adri.proyectotfg.Domain.Repository.UserRepository;
import com.adri.proyectotfg.Domain.Repository.WorkstationRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.UserInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.WorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.UserOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.WorkstationOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkstationServiceImpl implements WorkstationService {
    private final WorkstationRepository repository;
    private final WorkstationMapper mapper;

    @Override
    public WorkstationOutDto createWorkstation(WorkstationInDto dto) {
        Workstation ws = mapper.toEntity(dto);
        return mapper.toDto(repository.save(ws));
    }

    @Override
    public WorkstationOutDto getWorkstationById(Integer id) {
        Workstation ws = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workstation not found: " + id));
        return mapper.toDto(ws);
    }

    @Override
    public List<WorkstationOutDto> getAllWorkstations() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkstationOutDto> getWorkstationsByFloor(Integer floorId) {
        return repository.findByFloorId(floorId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WorkstationOutDto updateWorkstation(Integer id, WorkstationInDto dto) {
        Workstation ws = mapper.toEntity(dto);
        ws.setWorkstationId(id);
        return mapper.toDto(repository.save(ws));
    }

    @Override
    public void deleteWorkstation(Integer id) {
        repository.deleteById(id);
    }
}