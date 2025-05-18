package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.UserMapper;
import com.adri.proyectotfg.Application.Service.UserService;
import com.adri.proyectotfg.Domain.Entity.User;
import com.adri.proyectotfg.Domain.Repository.UserRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.UserInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.UserOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserOutDto createUser(UserInDto dto) {
        User user = userMapper.toEntity(dto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserOutDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserOutDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserOutDto updateUser(Integer id, UserInDto dto) {
        User user = userMapper.toEntity(dto);
        user.setUserId(id);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserOutDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found: " + email));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserOutDto> getUsersByCompany(Integer companyId) {
        return userRepository.findByCompanyId(companyId).stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}