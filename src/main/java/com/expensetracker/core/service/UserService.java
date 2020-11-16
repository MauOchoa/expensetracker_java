package com.expensetracker.core.service;

import com.expensetracker.core.entities.Account;
import com.expensetracker.core.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAllUsers();

    public  Optional<Account> findAccount(Long id);

    public Optional<User> findAllUsersById(Long id);

    public User saveUser(User userNew);

    public String deleteUser(Long id);

    public String updateUser(User userNew);

}
