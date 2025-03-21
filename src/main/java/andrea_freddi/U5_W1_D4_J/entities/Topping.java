package andrea_freddi.U5_W1_D4_J.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "toppings")
public class Topping extends Item {
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "toppings")
    private List<Pizza> pizzas;

    public Topping(String name, int calories, double price) {
        super(calories, price);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
