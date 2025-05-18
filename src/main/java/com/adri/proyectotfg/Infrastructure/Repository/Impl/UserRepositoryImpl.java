package com.adri.proyectotfg.Infrastructure.Repository.Impl;

import com.adri.proyectotfg.Domain.Entity.User;
import com.adri.proyectotfg.Domain.Repository.UserRepository;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository jpa;

    @Override
    public User save(User user) {
        return jpa.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return jpa.findById(id);
    }

    @Override
    public List<User> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpa.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpa.findByEmail(email);
    }

    @Override
    public List<User> findByCompanyId(Integer companyId) {
        return jpa.findByCompanyCompanyId(companyId);
    }
}