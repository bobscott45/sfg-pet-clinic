package dev.bobscott.sfgpetclinic.repositories;

import dev.bobscott.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
