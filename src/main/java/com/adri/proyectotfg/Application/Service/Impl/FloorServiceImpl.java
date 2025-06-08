package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.FloorMapper;
import com.adri.proyectotfg.Application.Service.FloorService;
import com.adri.proyectotfg.Domain.Entity.Floor;
import com.adri.proyectotfg.Domain.Repository.FloorRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.FloorInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.FloorOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FloorServiceImpl implements FloorService {
    private final FloorRepository floorRepository;
    private final FloorMapper floorMapper;

    @Override
    public FloorOutDto createFloor(FloorInDto dto) {
        Floor floor = floorMapper.toEntity(dto);
        return floorMapper.toDto(floorRepository.save(floor));
    }

    @Override
    public FloorOutDto getFloorById(Integer id) {
        Floor floor = floorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Floor not found: " + id));
        return floorMapper.toDto(floor);
    }

    @Override
    public List<FloorOutDto> getAllFloors() {
        return floorRepository.findAll().stream()
                .map(floorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FloorOutDto updateFloor(Integer id, FloorInDto dto) {
        Floor floor = floorMapper.toEntity(dto);
        floor.setFloorId(id);
        return floorMapper.toDto(floorRepository.save(floor));
    }

    @Override
    public void deleteFloor(Integer id) {
        floorRepository.deleteById(id);
    }

    @Override
    public List<FloorOutDto> getFloorsByCompanyId(Integer companyId) {
        List<Floor> floors = floorRepository.getFloorsByCompanyId(companyId);
        return floors.stream()
                .map(floorMapper::toDto)
                .collect(Collectors.toList());
    }
}