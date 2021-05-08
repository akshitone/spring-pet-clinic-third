package akshitone.springtutorial.petclinicthird.repositories;

import akshitone.springtutorial.petclinicthird.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
