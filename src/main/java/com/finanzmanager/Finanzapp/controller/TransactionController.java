package com.finanzmanager.Finanzapp.controller;

import com.finanzmanager.Finanzapp.model.Transaction;
import com.finanzmanager.Finanzapp.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionService service;
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return service.getAll();
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return service.save(transaction);
    }

}
