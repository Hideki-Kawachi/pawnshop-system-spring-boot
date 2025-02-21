package com.hideki.pawnshopSystem.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PawnDTO(
        UUID idPawn,
        String pawnTicketID,
        BigDecimal interest,
        BigDecimal principal,
        LocalDate startDate,
        LocalDate endDate
) {
}
