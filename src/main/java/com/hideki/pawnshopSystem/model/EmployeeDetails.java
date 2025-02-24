package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "employeeDetails")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idEmployeeDetails;

    @OneToOne
    @JoinColumn(name = "idEmployee", referencedColumnName = "idAppUser")
    @Column(nullable = false)
    private AppUser employee;

    @Column(nullable = false)
    private BigDecimal baseSalary;

    @Column(nullable = false)
    private BigDecimal allowances;

    @Column(nullable = false)
    private BigDecimal addBenefits;

    @Column(nullable = false)
    private LocalDateTime joinDate;
}
