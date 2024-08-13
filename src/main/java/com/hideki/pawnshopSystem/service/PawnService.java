package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.dto.PawnDTO;
import com.hideki.pawnshopSystem.model.Pawn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface PawnService {
    public PawnDTO createPawn(BigDecimal principal, LocalDate startDate);
    public String generatePawnTicketID();
    public List<Pawn> getAllPawn();
    public Optional<Pawn> getPawnByID(Integer id);
}
