package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "redemption")
public class Redemption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idRedemption;

    @OneToOne
    @JoinColumn(name = "idPawn")
    private Pawn pawn;

    private LocalDate redemptionDate;
    private BigDecimal payment;
    private BigDecimal interest;

    @ManyToOne
    @JoinColumn(name = "idTransaction")
    private Transaction transaction;

    public Redemption(Pawn pawn, LocalDate redemptionDate, BigDecimal payment, BigDecimal interest) {
        this.pawn = pawn;
        this.redemptionDate = redemptionDate;
        this.payment = payment;
        this.interest = interest;
    }
}
