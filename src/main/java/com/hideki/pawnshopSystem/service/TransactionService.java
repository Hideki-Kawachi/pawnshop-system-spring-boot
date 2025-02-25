package com.hideki.pawnshopSystem.service;

import java.math.BigDecimal;
import java.util.UUID;

public class TransactionService{



    public void createOtherTransaction(BigDecimal netAmount) {

    }


    public void createPawnTransaction(BigDecimal principal, BigDecimal interest, UUID idClerk, UUID idCustomer) {
        BigDecimal netAmount = principal.subtract(interest).negate();


//        new Transaction(TransactionType.PAWN,netAmount)
    }


    public void createRenewalTransaction(BigDecimal netAmount, UUID idClerk, UUID idCustomer) {

    }


    public void createRedemptionTransaction(BigDecimal netAmount, UUID idClerk, UUID idCustomer) {

    }
}
