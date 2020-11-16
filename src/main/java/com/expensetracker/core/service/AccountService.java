package com.expensetracker.core.service;

import com.expensetracker.core.entities.Account;
import com.expensetracker.core.entities.User;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    public List<Account> findAllAccounts();

    public Optional<Account> findAllAccountsById(Long id);

    public Account saveAccount(Account accountNew);

    public String deleteAccount(Long id);

    public String updateAccount(Account accountNew);

}
