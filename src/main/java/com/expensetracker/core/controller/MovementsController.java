package com.expensetracker.core.controller;

import com.expensetracker.core.entities.Movements;

import java.util.List;
import java.util.Optional;

public interface MovementsController {

    public List<Movements> getMovements();

    public Optional<Movements> getMovementsById(Long id);

    public Movements addMovements(Movements movement);

    public String deleteMovements(Long id);

    public String updateMovements(Movements movementsNew);



}
