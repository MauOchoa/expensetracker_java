package com.expensetracker.core.controllerImpl;

import com.expensetracker.core.controller.MovementsController;
import com.expensetracker.core.entities.Movements;
import com.expensetracker.core.service.MovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MovementsControllerImpl implements MovementsController {

    @Autowired
    MovementsService movementsService;

    @RequestMapping(value = "/movements/", method = RequestMethod.GET, produces = "application/json")
    @Override
    public List<Movements> getMovements() {
        return movementsService.findAllMovements();
    }

    @RequestMapping(value = "/movements/{id}", method = RequestMethod.GET, produces = "application/json")
    @Override
    public Optional<Movements> getMovementsById(@PathVariable Long id) {
        return movementsService.findAllMovementsById(id);
    }

    @RequestMapping(value = "/movements/add", method = RequestMethod.POST, produces = "application/json")
    @Override
    public Movements addMovements(Movements movement) {
        return movementsService.saveMovements(movement);
    }

    @RequestMapping(value = "/movements/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @Override
    public String deleteMovements(@PathVariable Long id) {
        return movementsService.deleteMovements(id);
    }

    @RequestMapping(value = "/movements/update", method = RequestMethod.PATCH, produces = "application/json")
    @Override
    public String updateMovements(Movements movementsNew) {
        return movementsService.updateMovement(movementsNew);
    }

}
