package andrea_freddi.U5_W1_D4_J.services;

import andrea_freddi.U5_W1_D4_J.entities.Pizza;
import andrea_freddi.U5_W1_D4_J.exceptions.ValidationException;
import andrea_freddi.U5_W1_D4_J.repositories.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzasService {

    @Autowired
    private PizzasRepository pizzasRepository;

    public void savePizza(Pizza newPizza) {
        if (pizzasRepository.existsByName(newPizza.getName()))
            throw new ValidationException("Pizza già presente");
        pizzasRepository.save(newPizza);
        System.out.println("Pizza " + newPizza.getName() + " salvata correttamente");
    }
}
