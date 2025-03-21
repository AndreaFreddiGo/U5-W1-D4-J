package andrea_freddi.U5_W1_D4_J.repositories;

import andrea_freddi.U5_W1_D4_J.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzasRepository extends JpaRepository<Pizza, Long> {

    boolean existsByName(String name);
}
