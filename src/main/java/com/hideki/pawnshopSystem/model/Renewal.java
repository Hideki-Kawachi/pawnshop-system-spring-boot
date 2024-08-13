package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    @OneToOne
    @JoinColumn(name = "idTransaction")
    private Transaction transaction;

    public Renewal(Pawn originalPawn, Pawn newPawn, LocalDate renewalDate, BigDecimal payment, BigDecimal interest) {
        this.originalPawn = originalPawn;
        this.newPawn = newPawn;
        this.renewalDate = renewalDate;
        this.payment = payment;
        this.interest = interest;
    }

    public Pawn getOriginalPawn() {
        return originalPawn;
    }

    public void setOriginalPawn(Pawn originalPawn) {
        this.originalPawn = originalPawn;
    }

    public Pawn getNewPawn() {
        return newPawn;
    }

    public void setNewPawn(Pawn newPawn) {
        this.newPawn = newPawn;
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
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
