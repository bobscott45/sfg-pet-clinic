package dev.bobscott.sfgpetclinic.services.map;

import dev.bobscott.sfgpetclinic.model.Owner;
import dev.bobscott.sfgpetclinic.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerMapServiceTest {

    @Mock
    PetService petService;


    OwnerMapService ownerMapService;

    @BeforeEach
    void setUpEach() {
        MockitoAnnotations.initMocks(this);
        ownerMapService = new OwnerMapService(petService);

        Owner owner1 = new Owner();
        owner1.setLastName("owner1");
        ownerMapService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setLastName("owner2");
        ownerMapService.save(owner2);
    }

    @Test
    void findById() {
        assertEquals(1L, ownerMapService.findById(1L).getId().longValue());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName("owner1");
        assertEquals(1L, owner.getId().longValue());
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findAll() {
    }
}