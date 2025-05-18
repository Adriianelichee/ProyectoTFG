package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.PurchasedService;
import com.adri.proyectotfg.Infrastructure.Dto.In.PurchasedServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.PurchasedServiceOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class, ServiceMapper.class})
public interface PurchasedServiceMapper {
    PurchasedServiceMapper INSTANCE = Mappers.getMapper(PurchasedServiceMapper.class);

    @Mapping(source = "companyId", target = "company.companyId")
    @Mapping(source = "serviceId", target = "service.serviceId")
    PurchasedService toEntity(PurchasedServiceInDto dto);

    @Mapping(source = "company.companyId", target = "companyId")
    @Mapping(source = "service.serviceId", target = "serviceId")
    PurchasedServiceOutDto toDto(PurchasedService entity);
}
