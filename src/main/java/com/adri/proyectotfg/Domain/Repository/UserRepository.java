package com.adri.proyectotfg.Domain.Repository;


import com.adri.proyectotfg.Domain.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Integer id);
    List<User> findAll();
    void deleteById(Integer id);
    Optional<User> findByEmail(String email);
    List<User> findByCompanyId(Integer companyId);
}