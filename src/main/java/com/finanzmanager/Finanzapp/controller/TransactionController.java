package com.finanzmanager.Finanzapp.controller;

import com.finanzmanager.Finanzapp.model.Transaction;
import com.finanzmanager.Finanzapp.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@SuppressWarnings("java:S4684")
public class TransactionController {
    private final TransactionService service;
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = service.getAll();
        return ResponseEntity.ok(transactions);

    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return service.save(transaction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable Long id) {
        Transaction transaction = service.getById(id);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        }else  {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public List<Transaction> searchByTitle(@RequestParam String title) {
        return service.searchByTitle(title);
    }

}
