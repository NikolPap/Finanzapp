package com.finanzmanager.Finanzapp.repository;


import com.finanzmanager.Finanzapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByDateBetween(LocalDate start, LocalDate end);
    List<Transaction> findByTitleContainingIgnoreCase(String title);
}
