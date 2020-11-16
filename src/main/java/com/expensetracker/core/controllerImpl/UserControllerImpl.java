package com.expensetracker.core.controllerImpl;

import com.expensetracker.core.controller.UserController;
import com.expensetracker.core.entities.Account;
import com.expensetracker.core.entities.User;
import com.expensetracker.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<User> getUser() {
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/user/{id}/account", method = RequestMethod.GET, produces = "application/json")
    @Override
    public Optional<Account> getAccount(@PathVariable Long id) {
        return userService.findAccount(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findAllUsersById(id);
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST, produces = "application/json")
    @Override
    public User addUser(User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @Override
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.PATCH, produces = "application/json")
    @Override
    public String updateUser(User userNew) {
        return userService.updateUser(userNew);
    }

    @RequestMapping(value ="/test", method = RequestMethod.GET, produces = "application/json")
    @Override
    public String test() {
        return "Test done succesfully";
    }
}
