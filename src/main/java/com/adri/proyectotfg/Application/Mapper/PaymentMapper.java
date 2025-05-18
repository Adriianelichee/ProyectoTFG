package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.Cleaning;
import com.adri.proyectotfg.Domain.Entity.Payment;
import com.adri.proyectotfg.Infrastructure.Dto.In.CleaningInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.PaymentInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CleaningOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.PaymentOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(source = "companyId", target = "company.companyId")
    Payment toEntity(PaymentInDto dto);

    @Mapping(source = "company.companyId", target = "companyId")
    PaymentOutDto toDto(Payment entity);
}