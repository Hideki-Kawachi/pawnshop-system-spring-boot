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
@Table(name = "computation")
public class Computation extends BaseDbModel {
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
}
