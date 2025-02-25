package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.shared.BaseDbModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employeeDetails")
public class EmployeeDetails extends BaseDbModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idEmployeeDetails;

    @OneToOne
    @JoinColumn(name = "idEmployee", referencedColumnName = "idAppUser")
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
