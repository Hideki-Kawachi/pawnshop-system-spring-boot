package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.model.Pawn;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PawnService {
    Pawn createPawn(BigDecimal principal, LocalDate startDate);
    String generatePawnTicketID();
}
