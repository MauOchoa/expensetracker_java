package com.expensetracker.core.controller;

import com.expensetracker.core.entities.Account;
import com.expensetracker.core.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserController {

    public List<User> getUser();

    public Optional<Account> getAccount(Long id);

    public Optional<User> getUserById(Long id);

    public User addUser(User user);

    public String deleteUser(Long id);

    public String updateUser(User userNew);

    public String test();

}
