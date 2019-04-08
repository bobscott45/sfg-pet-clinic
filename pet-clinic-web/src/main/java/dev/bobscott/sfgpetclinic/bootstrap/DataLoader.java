package dev.bobscott.sfgpetclinic.bootstrap;

import dev.bobscott.sfgpetclinic.model.*;
import dev.bobscott.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final PetService petService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, PetService petService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.petService = petService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        Speciality cardiacSpeciality = new Speciality();
        cardiacSpeciality.setDescription("Cardiac");
        specialtyService.save(cardiacSpeciality);

        Speciality arthritisSpeciality = new Speciality();
        arthritisSpeciality.setDescription("Arthritis");
        specialtyService.save(arthritisSpeciality);

        Speciality dentistrySpeciality = new Speciality();
        dentistrySpeciality.setDescription("Dentistry");
        specialtyService.save(dentistrySpeciality);

        PetType dog = new PetType();
        dog.setName("Dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        cat = petTypeService.save(cat);

        Owner mike= new Owner();
        mike.setFirstName("Michael");
        mike.setLastName("Weston");
        mike.setAddress("123 Brickerel");
        mike.setCity("Miami");
        mike.setTelephone("123-1353432");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setName("Fido");
        mikesPet.setOwner(mike);
        mikesPet.setBirthDate(LocalDate.now());
        mike.getPets().add(mikesPet);

        ownerService.save(mike);

        Owner fiona = new Owner();
        fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glenanne");
        fiona.setAddress("553 High Street");
        fiona.setCity("Orlando");
        fiona.setTelephone("223-1345563");

        Pet fionasPet = new Pet();
        fionasPet.setOwner(fiona);
        fionasPet.setPetType(cat);
        fionasPet.setName("Mini");
        fionasPet.setBirthDate(LocalDate.now());
        fiona.getPets().add(fionasPet);
        ownerService.save(fiona);


        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(cardiacSpeciality);
        vet1.getSpecialities().add(dentistrySpeciality);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(arthritisSpeciality);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");

        createPetVisit(fionasPet, LocalDate.now(), "Fist visit to Fiona's cat");
        createPetVisit(mikesPet, LocalDate.now(), "First visit to Mikes's dog");
        createPetVisit(fionasPet, LocalDate.now(), "Second visit to Fiona's cat");

        System.out.println("Loaded Visits....");

    }

    public void createPetVisit(Pet pet, LocalDate date, String description) {
        Visit visit = new Visit();
        visit.setDate(date);
        visit.setDescription(description);
        visit.setPet(pet);
        visitService.save(visit);
        pet.getVisits().add(visit);
        petService.save(pet);
    }
}
