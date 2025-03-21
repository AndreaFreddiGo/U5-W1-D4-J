package andrea_freddi.U5_W1_D4_J.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pizzas")
public class Pizza extends Item {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "is_xl", nullable = false)
    private boolean isXL = false;

    @ManyToMany
    @JoinTable(
            name = "pizzas_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings;

    public Pizza(String name, List<Topping> toppings, boolean isXL) {
        super(1012, 4.3);
        this.name = name;
        this.toppings = toppings;
        this.isXL = isXL;
        this.calories = setCalories(toppings, isXL);
        this.price = setPrice(toppings, isXL);
    }

    public int setCalories(List<Topping> toppingList, boolean isXl) {
        int tot = 1012;
        if (toppingList != null) {
            for (int i = 0; i < toppingList.size(); i++) {
                tot += toppingList.get(i).getCalories();
            }
        }
        if (isXl) return (tot += (tot * 5) / 100);
        else return tot;
    }

    public double setPrice(List<Topping> t, boolean isXl) {
        double tot = 4.30;
        if (t != null) {
            for (int i = 0; i < t.size(); i++) {
                tot += t.get(i).getPrice();
            }
        }

        if (isXl) return tot += (tot * 10) / 100;
        else return tot;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "isXL=" + isXL +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
