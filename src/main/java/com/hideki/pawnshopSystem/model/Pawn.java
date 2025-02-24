package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "pawn")
public class Pawn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idPawn;

    @Column(nullable = false)
    private String pawnTicketID;

    @Column(nullable = false)
    private BigDecimal principal;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private boolean isOriginal;

    @OneToOne(mappedBy = "pawn")
    private Transaction transaction;


    //    To Do: Add creation of transaction
    public Pawn(String pawnTicketID, BigDecimal principal, LocalDate startDate) {
        this.pawnTicketID = pawnTicketID;
        this.principal = principal;
        this.startDate = startDate;
        this.endDate = startDate.plusMonths(3);
    }

}
