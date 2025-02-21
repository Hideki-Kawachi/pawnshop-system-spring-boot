package com.hideki.pawnshopSystem.model;


import com.hideki.pawnshopSystem.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idTransaction;
    private TransactionType type;
    private BigDecimal netAmount;

    @OneToOne(mappedBy = "transaction")
    private Pawn pawn;

    @OneToOne(mappedBy = "transaction")
    private Redemption redemption;

    @OneToOne(mappedBy = "transaction")
    private Renewal renewal;

    @OneToOne
    @JoinColumn(name = "idCustomer", referencedColumnName = "idUser")
    private AppUser customer;

    @OneToOne
    @JoinColumn(name = "idClerk", referencedColumnName = "idUser")
    private AppUser clerk;

    @OneToOne
    @JoinColumn(name = "idBranchManager", referencedColumnName = "idUser")
    private AppUser branchManager;

    //    constructor for pawn
    public Transaction(Pawn pawn, AppUser clerk, AppUser customer, AppUser branchManager) {
        this.type = TransactionType.PAWN;
        this.netAmount = pawn.getPrincipal().subtract(pawn.getInterest()).negate();
        this.customer = customer;
        this.clerk = clerk;
        this.pawn = pawn;
        this.branchManager = branchManager;
    }

    //    constructor for redemption
    public Transaction(Redemption redemption, AppUser clerk, AppUser customer, AppUser branchManager) {
        this.type = TransactionType.REDEMPTION;
        this.netAmount = redemption.getPayment();
        this.customer = customer;
        this.clerk = clerk;
        this.redemption = redemption;
        this.branchManager = branchManager;
    }

    //    constructor for renewal
    public Transaction(Renewal renewal, AppUser clerk, AppUser customer, AppUser branchManager) {
        this.type = TransactionType.RENEWAL;
        this.netAmount = renewal.getPayment();
        this.customer = customer;
        this.clerk = clerk;
        this.renewal = renewal;
        this.branchManager = branchManager;
    }

    //    constructor for other transaction
    public Transaction(TransactionType type, BigDecimal netAmount, AppUser clerk, AppUser branchManager) {
        this.type = type;
        this.netAmount = netAmount;
        this.clerk = clerk;
        this.branchManager = branchManager;
    }
}
