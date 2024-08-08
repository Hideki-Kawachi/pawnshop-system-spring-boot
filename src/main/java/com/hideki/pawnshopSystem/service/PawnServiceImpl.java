package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.model.Pawn;
import com.hideki.pawnshopSystem.repository.PawnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class PawnServiceImpl implements PawnService{

    @Autowired
    private PawnRepository pawnRepository;

    @Override
    public Pawn createPawn(BigDecimal principal, LocalDate startDate) {
        String pawnTicketID = generatePawnTicketID();
        return pawnRepository.save(new Pawn(pawnTicketID, principal, startDate));
    }

    @Override
    public String generatePawnTicketID(){
        String latestPawnTicketID = pawnRepository.findLatestPawnTicketID();
        if(latestPawnTicketID==null){
            return "A-000000";
        }


        String[] pawnTicketSplit = latestPawnTicketID.split("-",2);
        int pawnTicketNumber = Integer.parseInt(pawnTicketSplit[1])+1;
        char[] pawnTicketLetters = pawnTicketSplit[0].toCharArray();
        String finalPawnTicketLetters = pawnTicketSplit[0];
//        if pawnticket number is greater than 999,999
        if(pawnTicketNumber>=1000000){
//            Go through pawnticket letters to check if need to be incremented
            for (int letterIndex = pawnTicketLetters.length-1; letterIndex > 0; letterIndex--) {
//                if reached end of letters but all are Z
                if(letterIndex<0){
//                    create a new pawnticket letter string that contains a new letter but all are A
                    finalPawnTicketLetters = "A".repeat(pawnTicketLetters.length);
                    break;
                }
                char currPawnTicketLetter = pawnTicketLetters[letterIndex];
//                If letter is not Z, increment the letter
                if(currPawnTicketLetter!='Z'){
                    pawnTicketLetters[letterIndex]++;
                    finalPawnTicketLetters = new String(pawnTicketLetters);
                    break;
                }
            }

        }

//        if pawnticket number is less than 999,999
        return finalPawnTicketLetters + String.valueOf(pawnTicketNumber);

    }
}
