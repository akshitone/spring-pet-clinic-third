package akshitone.springtutorial.petclinicthird.services;

import akshitone.springtutorial.petclinicthird.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);

}
