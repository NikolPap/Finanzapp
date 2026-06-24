package com.finanzmanager.Finanzapp.service;

import com.finanzmanager.Finanzapp.model.Transaction;
import com.finanzmanager.Finanzapp.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAll() {
        return  repository.findAll();
    }

    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }


}
