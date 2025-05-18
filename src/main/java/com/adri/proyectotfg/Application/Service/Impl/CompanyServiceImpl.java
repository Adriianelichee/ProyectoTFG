package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.CompanyMapper;
import com.adri.proyectotfg.Application.Service.CompanyService;
import com.adri.proyectotfg.Domain.Entity.Company;
import com.adri.proyectotfg.Domain.Repository.CompanyRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.CompanyInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CompanyOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyOutDto createCompany(CompanyInDto dto) {
        Company company = companyMapper.toEntity(dto);
        return companyMapper.toDto(companyRepository.save(company));
    }

    @Override
    public CompanyOutDto getCompanyById(Integer id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found: " + id));
        return companyMapper.toDto(company);
    }

    @Override
    public List<CompanyOutDto> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyOutDto updateCompany(Integer id, CompanyInDto dto) {
        Company company = companyMapper.toEntity(dto);
        company.setCompanyId(id);
        return companyMapper.toDto(companyRepository.save(company));
    }

    @Override
    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }
}