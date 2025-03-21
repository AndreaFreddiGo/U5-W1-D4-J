package andrea_freddi.U5_W1_D4_J.services;

import andrea_freddi.U5_W1_D4_J.entities.Topping;
import andrea_freddi.U5_W1_D4_J.exceptions.ValidationException;
import andrea_freddi.U5_W1_D4_J.repositories.ToppingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToppingsService {

    @Autowired
    private ToppingsRepository toppingsRepository;

    public void saveTopping(Topping newTopping) {
        if (toppingsRepository.existsByName(newTopping.getName()))
            throw new ValidationException("Topping già presente");
        toppingsRepository.save(newTopping);
        System.out.println("Topping " + newTopping.getName() + " salvato correttamente");
    }
}
