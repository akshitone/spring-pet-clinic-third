package akshitone.springtutorial.petclinicthird.bootstrap;

import akshitone.springtutorial.petclinicthird.model.*;
import akshitone.springtutorial.petclinicthird.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int countPetType = petTypeService.findAll().size();
        if (countPetType == 0)
            initializeData();
    }

    private void initializeData() {
        Speciality heart = new Speciality();
        heart.setDescription("Heart special");
        Speciality heartSpeciality = specialityService.save(heart);

        Speciality eye = new Speciality();
        heart.setDescription("Eye special");
        Speciality eyeSpeciality = specialityService.save(eye);

        Speciality ear = new Speciality();
        heart.setDescription("Ear special");
        Speciality earSpeciality = specialityService.save(ear);

        System.out.println("Loaded specialities data...");

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

        Visit oreoVisit = new Visit();
        oreoVisit.setPet(chloePet);
        oreoVisit.setDate(LocalDate.now());
        oreoVisit.setDescription("Smelly cat");

        visitService.save(oreoVisit);

        System.out.println("Loaded owners data...");

        Vet omen = new Vet();
        omen.setFirstName("Omen");
        omen.setLastName("Teleport");
        omen.getSpecialities().add(heartSpeciality);
        omen.getSpecialities().add(eyeSpeciality);

        vetService.save(omen);

        Vet phoenix = new Vet();
        phoenix.setFirstName("Phoenix");
        phoenix.setLastName("Explosive");
        phoenix.getSpecialities().add(earSpeciality);

        vetService.save(phoenix);

        System.out.println("Loaded vets data...");
    }
}
