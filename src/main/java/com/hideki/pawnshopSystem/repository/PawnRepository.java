package com.hideki.pawnshopSystem.repository;

import com.hideki.pawnshopSystem.model.Pawn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PawnRepository extends JpaRepository<Pawn, String> {

}
