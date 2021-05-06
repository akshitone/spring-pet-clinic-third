package akshitone.springtutorial.petclinicthird.bootstrap;

import akshitone.springtutorial.petclinicthird.model.Owner;
import akshitone.springtutorial.petclinicthird.model.Pet;
import akshitone.springtutorial.petclinicthird.model.PetType;
import akshitone.springtutorial.petclinicthird.model.Vet;
import akshitone.springtutorial.petclinicthird.services.OwnerService;
import akshitone.springtutorial.petclinicthird.services.PetTypeService;
import akshitone.springtutorial.petclinicthird.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        lucifer.setAddress("105 Lux");
        lucifer.setCity("Los Angeles");
        lucifer.setTelephone("987987");

        Pet luciferPet = new Pet();
        luciferPet.setName("Rosco");
        luciferPet.setPetType(dog);
        luciferPet.setOwner(lucifer);
        luciferPet.setBirthDate(LocalDate.now());

        lucifer.getPets().add(luciferPet);

        ownerService.save(lucifer);

        Owner chloe = new Owner();
        chloe.setFirstName("Chloe");
        chloe.setLastName("Decker");
        chloe.setAddress("107 Decker Villa");
        chloe.setCity("Los Angeles");
        chloe.setTelephone("963963");

        Pet chloePet = new Pet();
        chloePet.setName("Oreo");
        chloePet.setPetType(cat);
        chloePet.setOwner(chloe);
        chloePet.setBirthDate(LocalDate.now());

        chloe.getPets().add(chloePet);

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
