package com.expensetracker.core.serviceImpl;

import com.expensetracker.core.entities.Movements;
import com.expensetracker.core.repository.MovementsRepository;
import com.expensetracker.core.service.MovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementsServiceImpl implements MovementsService {

    @Autowired
    MovementsRepository movementsRepository;

    @Override
    public List<Movements> findAllMovements() {
        return movementsRepository.findAll();
    }

    @Override
    public Optional<Movements> findAllMovementsById(Long id) {
        Optional<Movements> movements = movementsRepository.findById(id);
        return movements;
    }

    @Override
    public Movements saveMovements(Movements movementsNew) {
        if (movementsNew != null){
            return movementsRepository.save(movementsNew);
        }
        return new Movements();
    }

    @Override
    public String deleteMovements(Long id) {
        if (movementsRepository.findById(id).isPresent()){
            movementsRepository.deleteById(id);
            return "Deleted Succesfully";
        }
        return "Error deleting Item, Item does not exist";
    }

    @Override
    public String updateMovement(Movements movementsNew) {
        Long id = movementsNew.getId();
        if (movementsRepository.findById(id).isPresent()){
            Movements movements = new Movements();
            movements.setId(movementsNew.getId());
            movements.setAmount(movementsNew.getAmount());
            movements.setDate(movementsNew.getDate());
            movementsRepository.save(movements);
            return "Movement updated succesfully";
        }
        return "Error while updating element not found";
    }
}
