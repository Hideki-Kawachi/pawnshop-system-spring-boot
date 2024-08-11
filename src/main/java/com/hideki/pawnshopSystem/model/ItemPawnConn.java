package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;

@Entity
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

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
