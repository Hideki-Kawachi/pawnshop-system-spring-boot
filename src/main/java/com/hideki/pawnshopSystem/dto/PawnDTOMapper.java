package com.hideki.pawnshopSystem.dto;

import com.hideki.pawnshopSystem.model.Pawn;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PawnDTOMapper implements Function<Pawn, PawnDTO> {
    @Override
    public PawnDTO apply(Pawn pawn){
        return new PawnDTO(pawn.idPawn,
                pawn.getPawnTicketID(),
                pawn.getInterest(),
                pawn.getPrincipal(),
                pawn.getStartDate(),
                pawn.getEndDate());
    }
}
