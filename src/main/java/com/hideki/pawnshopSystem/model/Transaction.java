package com.hideki.pawnshopSystem.model;


import com.hideki.pawnshopSystem.enums.TransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idTransaction;
    private TransactionType type;
    private BigDecimal netAmount;

    @OneToOne(mappedBy = "transaction")
    private Pawn pawn;

    @OneToOne(mappedBy = "transaction")
    private Redemption redemption;

    @OneToOne(mappedBy = "transaction")
    private Renewal renewal;

    @OneToOne
    @JoinColumn(name = "idUser",referencedColumnName = "idCustomer")
    private User customer;

    @OneToOne
    @JoinColumn(name = "idUser",referencedColumnName = "idClerk")
    private User clerk;

//    constructor for pawn
    public Transaction(Pawn pawn, User clerk, User customer){
        this.type=TransactionType.PAWN;
        this.netAmount=pawn.getPrincipal().subtract(pawn.getInterest()).negate();
        this.customer=customer;
        this.clerk=clerk;
        this.pawn=pawn;
    }

//    constructor for redemption
    public Transaction(Redemption redemption, User clerk, User customer){
        this.type=TransactionType.REDEMPTION;
        this.netAmount=redemption.getPayment();
        this.customer=customer;
        this.clerk=clerk;
        this.redemption=redemption;
    }

//    constructor for redemption
    public Transaction(Renewal renewal, User clerk, User customer){
        this.type=TransactionType.RENEWAL;
        this.netAmount=renewal.getPayment();
        this.customer=customer;
        this.clerk=clerk;
        this.renewal=renewal;
    }

//    constructor for other transaction
    public Transaction(TransactionType type, BigDecimal netAmount, User clerk){
        this.type=type;
        this.netAmount=netAmount;
        this.clerk=clerk;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getClerk() {
        return clerk;
    }

    public void setClerk(User clerk) {
        this.clerk = clerk;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }
}
