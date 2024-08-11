package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "redemption")
public class Redemption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idTransaction;

    @OneToOne
    @JoinColumn(name = "idPawn")
    private Pawn pawn;

    private LocalDate redemptionDate;
    private BigDecimal payment;
    private BigDecimal interest;

    @OneToOne
    @JoinColumn(name = "idTransaction")
    private Transaction transaction;

    public Redemption(Pawn pawn, LocalDate redemptionDate, BigDecimal payment, BigDecimal interest) {
        this.pawn = pawn;
        this.redemptionDate = redemptionDate;
        this.payment = payment;
        this.interest = interest;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public LocalDate getRedemptionDate() {
        return redemptionDate;
    }

    public void setRedemptionDate(LocalDate redemptionDate) {
        this.redemptionDate = redemptionDate;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
