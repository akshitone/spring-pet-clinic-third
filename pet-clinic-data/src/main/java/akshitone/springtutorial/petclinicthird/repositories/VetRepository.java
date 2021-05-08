package akshitone.springtutorial.petclinicthird.repositories;

import akshitone.springtutorial.petclinicthird.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
