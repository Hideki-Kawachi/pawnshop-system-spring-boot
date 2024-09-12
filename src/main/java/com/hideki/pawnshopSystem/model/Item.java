package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.enums.ItemStatus;
import com.hideki.pawnshopSystem.enums.ItemType;
import com.hideki.pawnshopSystem.enums.MaterialType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idItem;
    private String name;
    private ItemType type;
    private String brand;
    private String model;
    private Float weight;
    private Integer purity;
    private MaterialType material;
    private String description;
    private BigDecimal pawnPrice;
    private ItemStatus status;
    private Integer idBranch;
    private String imageLink;
}
