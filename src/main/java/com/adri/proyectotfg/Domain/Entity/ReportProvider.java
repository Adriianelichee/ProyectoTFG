package com.adri.proyectotfg.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "reports_providers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer providerId;

    @Column(nullable = false)
    private String providerName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String contactEmail;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;
}

