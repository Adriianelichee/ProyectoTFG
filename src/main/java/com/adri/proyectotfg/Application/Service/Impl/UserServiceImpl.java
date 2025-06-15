package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.UserMapper;
import com.adri.proyectotfg.Application.Service.UserService;
import com.adri.proyectotfg.Domain.Entity.ReportProvider;
import com.adri.proyectotfg.Domain.Entity.User;
import com.adri.proyectotfg.Domain.Repository.ReportProviderRepository;
import com.adri.proyectotfg.Domain.Repository.UserRepository;
import com.adri.proyectotfg.Exception.EmailAlreadyExistsException;
import com.adri.proyectotfg.Infrastructure.Dto.In.UserInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.UserOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ReportProviderRepository reportProviderRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserOutDto createUser(UserInDto userInDto) {
        if (userRepository.findByEmail(userInDto.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("El email " + userInDto.getEmail() + " ya está registrado");
        }

        User user = userMapper.toEntity(userInDto);

        if (user.getProvider() != null) {
            ReportProvider provider = user.getProvider();
            if (provider.getContactEmail() == null || provider.getPhone() == null ||
                    provider.getProviderName() == null || provider.getSpecialty() == null) {
                user.setProvider(null);
            } else {
                ReportProvider savedProvider = reportProviderRepository.save(provider);
                user.setProvider(savedProvider);
            }
        }

        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
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
    @Transactional
    public UserOutDto updateUser(Integer id, UserInDto dto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));

        if (!dto.getEmail().equals(existingUser.getEmail())) {
            userRepository.findByEmail(dto.getEmail())
                    .ifPresent(user -> {
                        if (!user.getUserId().equals(id)) {
                            throw new EmailAlreadyExistsException("El email " + dto.getEmail() + " ya está registrado por otro usuario");
                        }
                    });
        }

        existingUser.setFirstName(dto.getFirstName());
        existingUser.setLastName(dto.getLastName());
        existingUser.setEmail(dto.getEmail());
        existingUser.setPhone(dto.getPhone());

        if (dto.getPassword() != null && !dto.getPassword().equals("NO_CHANGE")) {
            existingUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        existingUser.getCompany().setCompanyId(dto.getCompanyId());

        if (dto.getProviderId() != null) {
            if (existingUser.getProvider() == null ||
                    !existingUser.getProvider().getProviderId().equals(dto.getProviderId())) {
                ReportProvider provider = reportProviderRepository.findById(dto.getProviderId())
                        .orElseThrow(() -> new RuntimeException("Proveedor no encontrado: " + dto.getProviderId()));
                existingUser.setProvider(provider);
            }
        } else {
            existingUser.setProvider(null);
        }

        User savedUser = userRepository.save(existingUser);
        return userMapper.toDto(savedUser);
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