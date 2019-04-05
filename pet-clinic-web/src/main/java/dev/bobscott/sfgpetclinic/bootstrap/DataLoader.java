package dev.bobscott.sfgpetclinic.bootstrap;

import dev.bobscott.sfgpetclinic.model.Owner;
import dev.bobscott.sfgpetclinic.model.PetType;
import dev.bobscott.sfgpetclinic.model.Vet;
import dev.bobscott.sfgpetclinic.services.OwnerService;
import dev.bobscott.sfgpetclinic.services.PetTypeService;
import dev.bobscott.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        Owner owner= new Owner();
        owner.setFirstName("Michael");
        owner.setLastName("Weston");
        ownerService.save(owner);

        owner = new Owner();
        owner.setFirstName("Fiona");
        owner.setLastName("Glenanne");
        ownerService.save(owner);

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
