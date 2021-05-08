package akshitone.springtutorial.petclinicthird.repositories;

import akshitone.springtutorial.petclinicthird.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
