package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "itemPawnConn")
public class ItemPawnConn {
    @Id
    @Column(name = "idItemPawnConn")
    public Integer idItemPawnConn;


    @OneToOne
    @JoinColumn(name = "idPawn",referencedColumnName = "idPawn")
    private Pawn pawn;

    @OneToOne
    @JoinColumn(name = "idItem",referencedColumnName = "idItem")
    private Item item;

    public ItemPawnConn(Pawn pawn, Item item) {
        this.pawn = pawn;
        this.item = item;
    }

}
