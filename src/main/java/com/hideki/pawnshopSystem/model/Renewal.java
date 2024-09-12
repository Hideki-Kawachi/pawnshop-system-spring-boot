package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "renewal")
public class Renewal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idRenewal;

    @OneToOne
    @JoinColumn(name = "originalPawn",referencedColumnName = "idPawn")
    private Pawn originalPawn;

    @OneToOne
    @JoinColumn(name = "newPawn",referencedColumnName = "idPawn")
    private Pawn newPawn;

    private LocalDate renewalDate;
    private BigDecimal payment;
    private BigDecimal interest;

    @ManyToOne
    @JoinColumn(name = "idTransaction")
    private Transaction transaction;

    public Renewal(Pawn originalPawn, Pawn newPawn, LocalDate renewalDate, BigDecimal payment, BigDecimal interest) {
        this.originalPawn = originalPawn;
        this.newPawn = newPawn;
        this.renewalDate = renewalDate;
        this.payment = payment;
        this.interest = interest;
    }

}
