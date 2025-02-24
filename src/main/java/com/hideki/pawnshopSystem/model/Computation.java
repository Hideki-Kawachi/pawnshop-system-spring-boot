package com.hideki.pawnshopSystem.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "computation")
public class Computation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idComputation;

    @Column(nullable = false)
    private BigDecimal interestRate;

    @Column(nullable = false)
    private BigDecimal vat;

    @Column(nullable = false)
    private BigDecimal penaltyRate;

    @Column(nullable = false)
    private BigDecimal advInterestRate;

    @Column(nullable = false)
    private BigDecimal addFees;

    @Column(nullable = false)
    private LocalDateTime createdOn;
}
