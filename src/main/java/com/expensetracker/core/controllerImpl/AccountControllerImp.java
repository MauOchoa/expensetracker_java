package com.expensetracker.core.controllerImpl;

import com.expensetracker.core.controller.AccountController;
import com.expensetracker.core.entities.Account;
import com.expensetracker.core.entities.User;
import com.expensetracker.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountControllerImp implements AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<Account> getAccount() {
        return accountService.findAllAccounts();
    }


    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public Optional<Account> getAccountById(@PathVariable Long id) {
        return accountService.findAllAccountsById(id);
    }

    @RequestMapping(value = "/account/add", method = RequestMethod.POST, produces = "application/json")
    @Override
    public Account addAccount(Account account) {
        return accountService.saveAccount(account);
    }

    @RequestMapping(value = "/account/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @Override
    public String deleteAccount(@PathVariable Long id) {
        return accountService.deleteAccount(id);
    }

    @RequestMapping(value = "/account/update", method = RequestMethod.PATCH, produces = "application/json")
    @Override
    public String updateAccount(Account accountNew) {
        return accountService.updateAccount(accountNew);
    }

}
