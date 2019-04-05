package dev.bobscott.sfgpetclinic.bootstrap;

import dev.bobscott.sfgpetclinic.model.Owner;
import dev.bobscott.sfgpetclinic.model.Pet;
import dev.bobscott.sfgpetclinic.model.PetType;
import dev.bobscott.sfgpetclinic.model.Vet;
import dev.bobscott.sfgpetclinic.services.OwnerService;
import dev.bobscott.sfgpetclinic.services.PetTypeService;
import dev.bobscott.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

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
        ownerService.save(fiona);

        System.out.println("Loaded Owners....");

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Jessie");
        vet.setLastName("Porter");
        vetService.save(vet);

        System.out.println("Loaded Vets....");

    }
}
