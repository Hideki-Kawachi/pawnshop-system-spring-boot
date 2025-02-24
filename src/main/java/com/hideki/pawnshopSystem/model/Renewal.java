package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "renewal")
public class Renewal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idRenewal;

    @OneToOne
    @JoinColumn(name = "idOriginalPawn", referencedColumnName = "idPawn")
    private Pawn originalPawn;

    @OneToOne
    @JoinColumn(name = "idNewPawn", referencedColumnName = "idPawn")
    private Pawn newPawn;

    @Column(nullable = false)
    private LocalDateTime renewalDate;
    
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

    @OneToOne(mappedBy = "renewal")
    private Transaction transaction;

    public Renewal(Pawn originalPawn, Pawn newPawn, LocalDateTime renewalDate, BigDecimal payment, BigDecimal interest) {
        this.originalPawn = originalPawn;
        this.newPawn = newPawn;
        this.renewalDate = renewalDate;
        this.payment = payment;
        this.interest = interest;
    }
}
