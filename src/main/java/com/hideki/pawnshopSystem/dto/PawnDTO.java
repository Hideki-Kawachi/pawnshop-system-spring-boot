package com.hideki.pawnshopSystem.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PawnDTO(
        Integer idPawn,
        String pawnTicketID,
        BigDecimal interest,
        BigDecimal principal,
        LocalDate startDate,
        LocalDate endDate
) {
}
