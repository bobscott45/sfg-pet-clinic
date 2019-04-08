package dev.bobscott.sfgpetclinic.repositories;

import dev.bobscott.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface PetRepository extends CrudRepository<Pet, Long> {
    @Override
    Set<Pet> findAll();
}
