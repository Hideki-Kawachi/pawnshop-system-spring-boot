package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.dto.PawnDTO;
import com.hideki.pawnshopSystem.dto.PawnDTOMapper;
import com.hideki.pawnshopSystem.model.Pawn;
import com.hideki.pawnshopSystem.repository.PawnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PawnService{

    @Autowired
    private PawnRepository pawnRepository;

    private PawnDTOMapper pawnDTOMapper;


    public PawnDTO createPawn(BigDecimal principal, LocalDate startDate) {
        String pawnTicketID = generatePawnTicketID();
        return pawnDTOMapper.apply(pawnRepository.save(new Pawn(pawnTicketID, principal, startDate)));
    }


    public String generatePawnTicketID(){
        String latestPawnTicketID = pawnRepository.findLatestPawnTicketID();
        if(latestPawnTicketID==null){
            return "A-000000";
        }


        String[] pawnTicketSplit = latestPawnTicketID.split("-",2);
        int pawnTicketNumber = Integer.parseInt(pawnTicketSplit[1])+1;
        char[] pawnTicketLetters = pawnTicketSplit[0].toCharArray();
        String finalPawnTicketLetters = pawnTicketSplit[0];
//        if pawn ticket number is greater than 999,999
        if(pawnTicketNumber>=1000000){
//            Go through pawn ticket letters to check if it needs to be incremented
            for (int letterIndex = pawnTicketLetters.length-1; letterIndex >= 0; letterIndex--) {
//                if reached end of letters but all are Z
                if(letterIndex==0){
//                    create a new pawn ticket letter string that contains a new letter but all are A
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


    public List<Pawn> getAllPawn() {
        Sort sortingMethod = Sort.by(Sort.Direction.DESC, "startDate");
        return pawnRepository.findAll(sortingMethod);
    }

    
    public Optional<Pawn> getPawnByID(Integer id) {
        return pawnRepository.findById(id);
    }
}
