package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.enums.ItemStatus;
import com.hideki.pawnshopSystem.enums.ItemType;
import com.hideki.pawnshopSystem.enums.Purity;
import com.hideki.pawnshopSystem.shared.BaseDbModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "item")
public class Item extends BaseDbModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idItem;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private ItemType type;

    @Column(nullable = false)
    private BigDecimal weight;

    private Purity purity;
    private String description;
    private String imageSrc;

    @Column(nullable = false)
    private BigDecimal pawnPrice;

    @Column(nullable = false)
    private ItemStatus status;

    @ManyToOne
    @JoinColumn(name = "idBranch", referencedColumnName = "idBranch")
    private Branch branch;

    private BigDecimal sellingPrice;
    private LocalDateTime soldDate;
}
