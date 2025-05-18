package com.adri.proyectotfg.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "workstations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workstationId;

    @Column(nullable = false)
    private Boolean available;

    @Column(nullable = false)
    private BigDecimal hourlyRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;

    @OneToMany(mappedBy = "workstation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cleaning> cleanings;

    @OneToMany(mappedBy = "workstation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Report> reports;

    @OneToMany(mappedBy = "workstation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetailReservationWorkstation> detailReservations;
}

