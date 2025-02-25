package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.shared.BaseDbModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "branch")
public class Branch extends BaseDbModel {
    @Id
    @GeneratedValue
    public UUID idBranch;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String prefix;
}
