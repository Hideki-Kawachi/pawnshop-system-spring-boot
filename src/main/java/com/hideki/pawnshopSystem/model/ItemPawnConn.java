package com.hideki.pawnshopSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "itemPawnConn")
public class ItemPawnConn {
    @Id
    @Column(name = "idItemPawnConn")
    public Integer idItemPawnConn;
    private Integer idPawn;
    private Integer idItem;
}
