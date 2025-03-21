package andrea_freddi.U5_W1_D4_J.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "item_id", nullable = false)
    @Setter(AccessLevel.NONE)
    protected long id;
    @Column(name = "calories", nullable = false)
    protected int calories;
    @Column(name = "price", nullable = false)
    protected double price;

    public Item(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "calories=" + calories +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
