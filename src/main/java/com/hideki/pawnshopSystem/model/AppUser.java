package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.enums.Sex;
import com.hideki.pawnshopSystem.enums.UserType;
import com.hideki.pawnshopSystem.shared.BaseDbModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appUser")
public class AppUser extends BaseDbModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAppUser")
    public UUID idAppUser;

    @Column(nullable = false)
    private String firstName;
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(nullable = false)
    private LocalDate birthDate;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType type;
    
    @Column(nullable = false)
    private Boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.type.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

}
