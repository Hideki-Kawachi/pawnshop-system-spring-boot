package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.enums.ItemStatus;
import com.hideki.pawnshopSystem.enums.ItemType;
import com.hideki.pawnshopSystem.enums.MaterialType;
import jakarta.persistence.*;

import java.math.BigDecimal;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getPurity() {
        return purity;
    }

    public void setPurity(Integer purity) {
        this.purity = purity;
    }

    public MaterialType getMaterial() {
        return material;
    }

    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPawnPrice() {
        return pawnPrice;
    }

    public void setPawnPrice(BigDecimal pawnPrice) {
        this.pawnPrice = pawnPrice;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}
