package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.PurchasedServiceMapper;
import com.adri.proyectotfg.Application.Service.PurchasedServicesService;
import com.adri.proyectotfg.Domain.Entity.PurchasedService;
import com.adri.proyectotfg.Domain.Repository.PurchasedServiceRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.PurchasedServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.PurchasedServiceOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchasedServicesServiceImpl implements PurchasedServicesService {
    private final PurchasedServiceRepository repository;
    private final PurchasedServiceMapper mapper;

    @Override
    public PurchasedServiceOutDto createPurchasedService(PurchasedServiceInDto dto) {
        PurchasedService ps = mapper.toEntity(dto);
        return mapper.toDto(repository.save(ps));
    }

    @Override
    public PurchasedServiceOutDto getPurchasedServiceById(Integer id) {
        PurchasedService ps = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PurchasedService not found: " + id));
        return mapper.toDto(ps);
    }

    @Override
    public List<PurchasedServiceOutDto> getAllPurchasedServices() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PurchasedServiceOutDto> getPurchasedServicesByCompany(Integer companyId) {
        return repository.findByCompanyId(companyId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PurchasedServiceOutDto updatePurchasedService(Integer id, PurchasedServiceInDto dto) {
        PurchasedService ps = mapper.toEntity(dto);
        ps.setPurchasedServiceId(id);
        return mapper.toDto(repository.save(ps));
    }

    @Override
    public void deletePurchasedService(Integer id) {
        repository.deleteById(id);
    }
}
