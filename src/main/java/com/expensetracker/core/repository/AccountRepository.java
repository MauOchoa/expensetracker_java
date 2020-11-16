package com.expensetracker.core.repository;

import com.expensetracker.core.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account , Long> {

    void save(Optional<Account> accountToUpdate);

}
