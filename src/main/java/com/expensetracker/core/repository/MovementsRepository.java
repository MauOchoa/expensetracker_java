package com.expensetracker.core.repository;

import com.expensetracker.core.entities.Movements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovementsRepository extends JpaRepository<Movements, Long> {

    void save(Optional<Movements> movementToUpdate);

}
