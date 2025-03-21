package andrea_freddi.U5_W1_D4_J.repositories;

import andrea_freddi.U5_W1_D4_J.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinksRepository extends JpaRepository<Drink, Long> {

    boolean existsByName(String name);
}
