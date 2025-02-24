package com.hideki.pawnshopSystem.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "customerDetails")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID idCustomerDetails;

    @OneToOne
    @JoinColumn(name = "idCustomer", referencedColumnName = "idAppUser")
    private AppUser customer;

    private String address;
    private String phoneNumber;
    private String imageIdSrc;
}
