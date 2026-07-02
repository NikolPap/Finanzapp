package com.finanzmanager.Finanzapp.repository;

import com.finanzmanager.Finanzapp.model.BankAccount;
import lombok.Locked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
