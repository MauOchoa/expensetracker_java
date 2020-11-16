package com.expensetracker.core.serviceImpl;

import com.expensetracker.core.entities.Account;
import com.expensetracker.core.entities.User;
import com.expensetracker.core.repository.AccountRepository;
import com.expensetracker.core.repository.UserRepository;
import com.expensetracker.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findAllAccountsById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account;
    }

    @Override
    public Account saveAccount(Account accountNew) {
        if (accountNew != null){
            return accountRepository.save(accountNew);
        }
        return new Account();
    }

    @Override
    public String deleteAccount(Long id) {
        if (accountRepository.findById(id).isPresent()){
            accountRepository.deleteById(id);
            return "Account deleted succesfully";
        }
        return "Error element not present in dtabase!";
    }

    @Override
    public String updateAccount(Account accountNew) {
        Long id = accountNew.getId();
        if (accountRepository.findById(id).isPresent()){
            Account accountToUpdate = new Account();
            accountToUpdate.setId(accountNew.getId());
            accountToUpdate.setBalance(accountNew.getBalance());
            accountRepository.save(accountToUpdate);
            return "Account modified!";
        }
        return "Error, account not modified";
    }
}
