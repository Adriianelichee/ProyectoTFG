package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.ServiceMapper;
import com.adri.proyectotfg.Application.Service.ServicesService;
import com.adri.proyectotfg.Domain.Entity.Services;
import com.adri.proyectotfg.Domain.Repository.ServiceRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.ServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ServiceOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServicesService {
    private final ServiceRepository repository;
    private final ServiceMapper mapper;

    @Override
    public ServiceOutDto createService(ServiceInDto dto) {
        Services s = mapper.toEntity(dto);
        return mapper.toDto(repository.save(s));
    }

    @Override
    public ServiceOutDto getServiceById(Integer id) {
        Services s = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found: " + id));
        return mapper.toDto(s);
    }

    @Override
    public List<ServiceOutDto> getAllServices() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceOutDto updateService(Integer id, ServiceInDto dto) {
        Services s = mapper.toEntity(dto);
        s.setServiceId(id);
        return mapper.toDto(repository.save(s));
    }

    @Override
    public void deleteService(Integer id) {
        repository.deleteById(id);
    }
}
