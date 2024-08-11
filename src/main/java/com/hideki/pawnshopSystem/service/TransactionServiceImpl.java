package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.enums.TransactionType;
import com.hideki.pawnshopSystem.model.Transaction;

import java.math.BigDecimal;

public class TransactionServiceImpl implements TransactionService{


    @Override
    public void createOtherTransaction(BigDecimal netAmount) {

    }

    @Override
    public void createPawnTransaction(BigDecimal principal, BigDecimal interest, Integer idClerk, Integer idCustomer) {
        BigDecimal netAmount = principal.subtract(interest).negate();


//        new Transaction(TransactionType.PAWN,netAmount)
    }

    @Override
    public void createRenewalTransaction(BigDecimal netAmount, Integer idClerk, Integer idCustomer) {

    }

    @Override
    public void createRedemptionTransaction(BigDecimal netAmount, Integer idClerk, Integer idCustomer) {

    }
}
