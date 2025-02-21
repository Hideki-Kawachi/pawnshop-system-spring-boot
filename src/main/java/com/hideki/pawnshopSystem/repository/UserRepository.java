package com.hideki.pawnshopSystem.repository;

import com.hideki.pawnshopSystem.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByEmail(String email);
}
