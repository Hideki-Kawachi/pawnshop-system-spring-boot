package com.hideki.pawnshopSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.HashMap;

@Entity
public class Pawn {
    @Id
    public String id;
    private Float principal;
    private Date startDate;
    private Date endDate;
    private HashMap<Integer, Item> itemList;

    public Pawn() {
    }

    public Float getPrincipal() {
        return principal;
    }

    public void setPrincipal(Float principal) {
        this.principal = principal;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public HashMap<Integer, Item> getItemList() {
        return itemList;
    }

    public void setItemList(HashMap<Integer, Item> itemList) {
        this.itemList = itemList;
    }
}
