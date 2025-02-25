package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.shared.BaseDbModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "goldRate")
public class GoldRate extends BaseDbModel {
    @Id
    public UUID idGoldRate;

    private BigDecimal goldPerOunceUsd;
    private BigDecimal usdRate;
    private BigDecimal goldPerGramPhp;
}
