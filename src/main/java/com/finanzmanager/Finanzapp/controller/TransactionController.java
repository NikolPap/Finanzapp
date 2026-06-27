package com.finanzmanager.Finanzapp.controller;

import com.finanzmanager.Finanzapp.model.Transaction;
import com.finanzmanager.Finanzapp.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<?> createTransaction(@Valid @RequestBody Transaction transaction) {
        if (transaction.getId() != null) {
            return ResponseEntity.badRequest().body("Id muss null sein - Wird automatich generiiert");
        }
        Transaction saved = service.save(transaction);
        return ResponseEntity.created(URI.create(("/api/transaction/" + saved.getId()))).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable Long id) {
        Transaction transaction = service.getById(id);
        if (transaction != null) {
            return ResponseEntity.ok(transaction); //200 ok
        } else  {
            return ResponseEntity.notFound().build(); //4ß4
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Transaction>> searchByTitle(@RequestParam String title) {
        List<Transaction> results = service.searchByTitle(title);
        return ResponseEntity.ok(results);
    }

}
