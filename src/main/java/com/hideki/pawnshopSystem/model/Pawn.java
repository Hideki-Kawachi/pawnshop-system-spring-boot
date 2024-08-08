package com.hideki.pawnshopSystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pawn")
public class Pawn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idPawn;
    private String pawnTicketID;
    private BigDecimal principal;
    private LocalDate startDate;
    private LocalDate endDate;

    @JsonCreator
    public Pawn(@JsonProperty("principal") BigDecimal principal){
        this.principal=principal;
        this.startDate=LocalDate.now();
    }

    public Pawn(String pawnTicketID, BigDecimal principal, LocalDate startDate) {
        this.pawnTicketID=pawnTicketID;
        this.principal=principal;
        this.startDate=startDate;
        this.endDate=startDate.plusMonths(3);
    }

    public String getPawnTicketID() {
        return pawnTicketID;
    }

    public void setPawnTicketID(String pawnTicketID) {
        this.pawnTicketID = pawnTicketID;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
