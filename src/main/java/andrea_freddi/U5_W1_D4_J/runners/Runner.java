package andrea_freddi.U5_W1_D4_J.runners;


import andrea_freddi.U5_W1_D4_J.U5W1D4JApplication;
import andrea_freddi.U5_W1_D4_J.entities.Drink;
import andrea_freddi.U5_W1_D4_J.entities.Pizza;
import andrea_freddi.U5_W1_D4_J.entities.Topping;
import andrea_freddi.U5_W1_D4_J.services.DrinksService;
import andrea_freddi.U5_W1_D4_J.services.PizzasService;
import andrea_freddi.U5_W1_D4_J.services.ToppingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private DrinksService drinksService;
    @Autowired
    private ToppingsService toppingsService;
    @Autowired
    private PizzasService pizzasService;

    @Autowired
    private List<Pizza> pizzaList;
    @Autowired
    private List<Topping> toppingList;
    @Autowired
    private List<Drink> drinkList;


    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D4JApplication.class);
        try {

            for (Topping topping : toppingList) {
                toppingsService.saveTopping(topping);
            }
            for (Drink drink : drinkList) {
                drinksService.saveDrink(drink);
            }
            for (Pizza pizza : pizzaList) {
                pizzasService.savePizza(pizza);
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            ctx.close();
        }
    }
}

