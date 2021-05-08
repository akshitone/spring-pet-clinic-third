package akshitone.springtutorial.petclinicthird.repositories;

import akshitone.springtutorial.petclinicthird.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
