package com.expensetracker.core.controller;

import com.expensetracker.core.entities.Account;
import com.expensetracker.core.entities.User;

import java.util.List;
import java.util.Optional;

public interface AccountController {

    public List<Account> getAccount();

    public Optional<Account> getAccountById(Long id);

    public Account addAccount(Account account);

    public String deleteAccount(Long id);

    public String updateAccount(Account accountNew);



}
