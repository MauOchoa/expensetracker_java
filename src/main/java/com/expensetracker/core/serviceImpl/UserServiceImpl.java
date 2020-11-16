package com.expensetracker.core.serviceImpl;

import com.expensetracker.core.entities.Account;
import com.expensetracker.core.entities.User;
import com.expensetracker.core.repository.AccountRepository;
import com.expensetracker.core.repository.UserRepository;
import com.expensetracker.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Account> findAccount(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<User> findAllUsersById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public User saveUser(User userNew) {
        if (userNew != null){
            return userRepository.save(userNew);
        }
        return new User();
    }

    @Override
    public String deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return "User deleted succesfull";
        }
        return "Error, user not found!";
    }

    @Override
    public String updateUser(User userNew) {
        Long id = userNew.getId();
        if (userRepository.findById(id).isPresent()){
            User newUser = new User();
            newUser.setId(userNew.getId());
            newUser.setName(userNew.getName());
            newUser.setLastname(userNew.getLastname());
            userRepository.save(newUser);
            return "User updated succesfully";
        }
        return "Error updating, user not found";
    }
}
