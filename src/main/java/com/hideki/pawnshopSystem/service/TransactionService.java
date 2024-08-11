package com.hideki.pawnshopSystem.service;

import com.hideki.pawnshopSystem.enums.TransactionType;

import java.math.BigDecimal;

public interface TransactionService {
    public void createOtherTransaction(BigDecimal netAmount);
    public void createPawnTransaction(BigDecimal principal, BigDecimal interest, Integer idClerk, Integer idCustomer);
    public void createRenewalTransaction(BigDecimal netAmount, Integer idClerk, Integer idCustomer);
    public void createRedemptionTransaction(BigDecimal netAmount, Integer idClerk, Integer idCustomer);
}
