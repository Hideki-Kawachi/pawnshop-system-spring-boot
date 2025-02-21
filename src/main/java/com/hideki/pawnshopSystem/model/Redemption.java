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

    @OneToOne
    @JoinColumn(name = "idPawn")
    private Pawn pawn;

    private LocalDateTime redemptionDate;
    private BigDecimal payment;
    private BigDecimal interest;

    @ManyToOne
    @JoinColumn(name = "idTransaction")
    private Transaction transaction;

    public Redemption(Pawn pawn, LocalDateTime redemptionDate, BigDecimal payment, BigDecimal interest) {
        this.pawn = pawn;
        this.redemptionDate = redemptionDate;
        this.payment = payment;
        this.interest = interest;
    }
}
