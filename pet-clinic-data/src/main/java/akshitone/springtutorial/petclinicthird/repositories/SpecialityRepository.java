package akshitone.springtutorial.petclinicthird.repositories;

import akshitone.springtutorial.petclinicthird.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
