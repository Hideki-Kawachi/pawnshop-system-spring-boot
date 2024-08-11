package com.hideki.pawnshopSystem.repository;

import com.hideki.pawnshopSystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
