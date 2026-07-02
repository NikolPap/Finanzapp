package com.finanzmanager.Finanzapp.service;

import com.finanzmanager.Finanzapp.model.BankAccount;
import com.finanzmanager.Finanzapp.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    private  final BankAccountRepository repository;
    public BankAccountService(BankAccountRepository repository) {
        this.repository = repository;
    }

    public BankAccount crate(){
        BankAccount account = new BankAccount();
        account.setBalance(0.0);
        return repository.save(account);
    }

    public BankAccount applyTransaction(Long id, double amount){
        BankAccount account = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Bank account not found"));
        account.applyTransaction(amount);
        return repository.save(account);
    }

    public BankAccount getById(Long id){
        return repository.findById(id).orElse(null);
}
}
