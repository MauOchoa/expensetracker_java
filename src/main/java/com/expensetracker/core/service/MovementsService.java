package com.expensetracker.core.service;

import com.expensetracker.core.entities.Movements;

import java.util.List;
import java.util.Optional;

public interface MovementsService {

    public List<Movements> findAllMovements();

    public Optional<Movements> findAllMovementsById(Long id);

    public Movements saveMovements(Movements movementsNew);

    public String deleteMovements(Long id);

    public String updateMovement(Movements movementsNew);


}
