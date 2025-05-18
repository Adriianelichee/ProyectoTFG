package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.CompanyInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.UserInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CompanyOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.UserOutDto;

import java.util.List;

public interface UserService {
    UserOutDto createUser(UserInDto dto);
    UserOutDto getUserById(Integer id);
    List<UserOutDto> getAllUsers();
    UserOutDto updateUser(Integer id, UserInDto dto);
    void deleteUser(Integer id);
    UserOutDto getUserByEmail(String email);
    List<UserOutDto> getUsersByCompany(Integer companyId);
}