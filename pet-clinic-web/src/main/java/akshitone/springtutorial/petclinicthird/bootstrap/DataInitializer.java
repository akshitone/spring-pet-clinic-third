package akshitone.springtutorial.petclinicthird.bootstrap;

import akshitone.springtutorial.petclinicthird.model.Owner;
import akshitone.springtutorial.petclinicthird.model.Vet;
import akshitone.springtutorial.petclinicthird.services.OwnerService;
import akshitone.springtutorial.petclinicthird.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
