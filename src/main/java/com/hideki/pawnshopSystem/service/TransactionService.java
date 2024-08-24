package com.hideki.pawnshopSystem.service;

import java.math.BigDecimal;

public class TransactionService{



    public void createOtherTransaction(BigDecimal netAmount) {

    }


    public void createPawnTransaction(BigDecimal principal, BigDecimal interest, Integer idClerk, Integer idCustomer) {
        BigDecimal netAmount = principal.subtract(interest).negate();


//        new Transaction(TransactionType.PAWN,netAmount)
    }


    public void createRenewalTransaction(BigDecimal netAmount, Integer idClerk, Integer idCustomer) {

    }


    public void createRedemptionTransaction(BigDecimal netAmount, Integer idClerk, Integer idCustomer) {

    }
}
