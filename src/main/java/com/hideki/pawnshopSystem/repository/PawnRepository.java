package com.hideki.pawnshopSystem.repository;

import com.hideki.pawnshopSystem.model.Pawn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PawnRepository extends JpaRepository<Pawn, Integer> {
    @Query(value = "select p.pawnTicketID from pawn p order by p.idPawn desc limit 1", nativeQuery = true)
    String findLatestPawnTicketID();
}
