package com.adri.proyectotfg.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchased_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasedService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchasedServiceId;

    @Column(nullable = false)
    private LocalDateTime purchaseDate;

    private LocalDateTime expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private Services services;
}
