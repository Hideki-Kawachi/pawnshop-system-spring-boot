package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.enums.ItemStatus;
import com.hideki.pawnshopSystem.enums.ItemType;
import com.hideki.pawnshopSystem.enums.Purity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idItem;
    private String name;
    private ItemType type;
    private BigDecimal weight;
    private Purity purity;
    private String description;
    private String imageSrc;
    private BigDecimal pawnPrice;
    private ItemStatus status;
    private UUID idBranch;

}
