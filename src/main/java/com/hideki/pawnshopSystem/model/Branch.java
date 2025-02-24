package com.hideki.pawnshopSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "branch")
public class Branch {
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
