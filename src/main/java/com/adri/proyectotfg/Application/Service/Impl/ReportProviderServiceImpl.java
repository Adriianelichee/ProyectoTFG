package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.ReportProviderMapper;
import com.adri.proyectotfg.Application.Service.ReportProviderService;
import com.adri.proyectotfg.Domain.Entity.ReportProvider;
import com.adri.proyectotfg.Domain.Repository.ReportProviderRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportProviderInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportProviderOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportProviderServiceImpl implements ReportProviderService {
    private final ReportProviderRepository providerRepository;
    private final ReportProviderMapper providerMapper;

    @Override
    public ReportProviderOutDto createProvider(ReportProviderInDto dto) {
        ReportProvider provider = providerMapper.toEntity(dto);
        return providerMapper.toDto(providerRepository.save(provider));
    }

    @Override
    public ReportProviderOutDto getProviderById(Integer id) {
        ReportProvider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found: " + id));
        return providerMapper.toDto(provider);
    }

    @Override
    public List<ReportProviderOutDto> getAllProviders() {
        return providerRepository.findAll().stream()
                .map(providerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReportProviderOutDto updateProvider(Integer id, ReportProviderInDto dto) {
        ReportProvider provider = providerMapper.toEntity(dto);
        provider.setProviderId(id);
        return providerMapper.toDto(providerRepository.save(provider));
    }

    @Override
    public void deleteProvider(Integer id) {
        providerRepository.deleteById(id);
    }
}