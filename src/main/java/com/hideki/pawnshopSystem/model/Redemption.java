package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "redemption")
public class Redemption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idRedemption;

    @ManyToOne
    @JoinColumn(name = "idOriginalPawn", referencedColumnName = "idPawn")
    private Pawn originalPawn;

    @OneToOne
    @JoinColumn(name = "idNewPawn", referencedColumnName = "idPawn")
    private Pawn newPawn;

    @Column(nullable = false)
    private LocalDateTime redemptionDate;

    @Column(nullable = false)
    private BigDecimal payment;

    @Column(nullable = false)
    private BigDecimal interest;

    @Column(nullable = false)
    private BigDecimal penalty;

    @Column(nullable = false)
    private BigDecimal addFees;

    @Column(nullable = false)
    private BigDecimal discount;

    @OneToOne(mappedBy = "redemption")
    private Transaction transaction;
}
