package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.enums.Sex;
import com.hideki.pawnshopSystem.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appUser")
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAppUser")
    public UUID idAppUser;

    @Column(nullable = false)
    private String firstName;
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType type;

    @Column(nullable = false)
    private LocalDateTime createdOn;
    
    @Column(nullable = false)
    private Boolean isActive;

    public AppUser(String firstName, String middleName, String lastName, Sex sex, LocalDate birthDate, String email, String password, UserType type) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.type = type;
        this.sex = sex;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.type.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

}
