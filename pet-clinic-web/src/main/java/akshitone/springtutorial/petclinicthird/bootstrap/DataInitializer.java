package akshitone.springtutorial.petclinicthird.bootstrap;

import akshitone.springtutorial.petclinicthird.model.Owner;
import akshitone.springtutorial.petclinicthird.model.PetType;
import akshitone.springtutorial.petclinicthird.model.Vet;
import akshitone.springtutorial.petclinicthird.services.OwnerService;
import akshitone.springtutorial.petclinicthird.services.PetTypeService;
import akshitone.springtutorial.petclinicthird.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types data...");

        Owner lucifer = new Owner();
        lucifer.setFirstName("Lucifer");
        lucifer.setLastName("Morningstar");
        ownerService.save(lucifer);

        Owner chloe = new Owner();
        chloe.setFirstName("Chloe");
        chloe.setLastName("Decker");
        ownerService.save(chloe);

        System.out.println("Loaded owners data...");

        Vet omen = new Vet();
        omen.setFirstName("Omen");
        omen.setLastName("Teleport");
        vetService.save(omen);

        Vet phoenix = new Vet();
        phoenix.setFirstName("Phoenix");
        phoenix.setLastName("Explosive");
        vetService.save(phoenix);

        System.out.println("Loaded vets data...");
    }
}
