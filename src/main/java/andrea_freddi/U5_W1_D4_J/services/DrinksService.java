package andrea_freddi.U5_W1_D4_J.services;

import andrea_freddi.U5_W1_D4_J.entities.Drink;
import andrea_freddi.U5_W1_D4_J.exceptions.ValidationException;
import andrea_freddi.U5_W1_D4_J.repositories.DrinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinksService {
    @Autowired
    private DrinksRepository drinksRepository;

    public void saveDrink(Drink newDrink) {
        if (drinksRepository.existsByName(newDrink.getName()))
            throw new ValidationException("Drink già presente");
        drinksRepository.save(newDrink);
        System.out.println("Drink " + newDrink.getName() + " salvato correttamente");
    }
}
