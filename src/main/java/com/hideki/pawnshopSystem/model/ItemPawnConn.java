package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.shared.BaseDbModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table(name = "itemPawnConn")
public class ItemPawnConn extends BaseDbModel {
    @Id
    @Column(name = "idItemPawnConn")
    public UUID idItemPawnConn;

    @OneToOne
    @JoinColumn(name = "idPawn", referencedColumnName = "idPawn")
    private Pawn pawn;

    @OneToOne
    @JoinColumn(name = "idItem", referencedColumnName = "idItem")
    private Item item;

    public ItemPawnConn(Pawn pawn, Item item) {
        this.pawn = pawn;
        this.item = item;
    }

}
