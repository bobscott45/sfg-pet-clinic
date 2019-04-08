package dev.bobscott.sfgpetclinic.repositories;

import dev.bobscott.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
    @Override
    Set<PetType> findAll();
}
