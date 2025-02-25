package com.hideki.pawnshopSystem.model;


import com.hideki.pawnshopSystem.shared.BaseDbModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "customerDetails")
public class CustomerDetails extends BaseDbModel {
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
