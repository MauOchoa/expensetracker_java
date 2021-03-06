package com.expensetracker.core.repository;

import com.expensetracker.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {

    void save(Optional<User> userToUpdate);
}
