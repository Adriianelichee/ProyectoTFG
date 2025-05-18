package com.adri.proyectotfg.Application.Mapper;

import com.adri.proyectotfg.Domain.Entity.User;
import com.adri.proyectotfg.Infrastructure.Dto.In.UserInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.UserOutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class, ReportProviderMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "companyId", target = "company.companyId")
    @Mapping(source = "providerId", target = "provider.providerId")
    User toEntity(UserInDto dto);

    @Mapping(source = "company.companyId", target = "companyId")
    @Mapping(source = "provider.providerId", target = "providerId")
    UserOutDto toDto(User entity);
}