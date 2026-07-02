package com.finanzmanager.Finanzapp.controller;

import com.finanzmanager.Finanzapp.model.BankAccount;
import com.finanzmanager.Finanzapp.repository.BankAccountRepository;
import com.finanzmanager.Finanzapp.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {
    private final BankAccountService service;
    public BankAccountController(BankAccountService service){
        this.service = service;
    }

    //Konto anlegen
    @PostMapping
    public ResponseEntity<BankAccount> create(){
        return  ResponseEntity.ok(service.crate());
    }

    //Transaktion ausführen
    @PostMapping("/{id}/transaction")
    public ResponseEntity<BankAccount> transaction(@PathVariable Long id, @RequestParam double amount){
        return ResponseEntity.ok(service.applyTransaction(id, amount));
    }

    //Konto abrufren
    @GetMapping("/id")
    public ResponseEntity<BankAccount> getById(@PathVariable Long id){
        BankAccount account = service.getById(id);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }






}
