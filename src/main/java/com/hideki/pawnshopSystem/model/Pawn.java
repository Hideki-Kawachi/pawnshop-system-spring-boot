package com.hideki.pawnshopSystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pawn")
public class Pawn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idPawn;
    private String pawnTicketID;
    private BigDecimal interest;
    private BigDecimal principal;
    private LocalDate startDate;
    private LocalDate endDate;


    @ManyToOne
    @JoinColumn(name = "idTransaction",nullable = false)
    private Transaction transaction;

//    @JsonCreator
//    public Pawn(@JsonProperty("principal") BigDecimal principal){
//        this.principal=principal;
//        this.startDate=LocalDate.now();
//    }

//    To Do: Add creation of transaction
    public Pawn(String pawnTicketID, BigDecimal principal, LocalDate startDate) {
        this.pawnTicketID=pawnTicketID;
        this.principal=principal;
        this.startDate=startDate;
        this.endDate=startDate.plusMonths(3);
    }

}
