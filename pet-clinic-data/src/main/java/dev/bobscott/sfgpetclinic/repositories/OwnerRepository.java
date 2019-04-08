package dev.bobscott.sfgpetclinic.repositories;

import dev.bobscott.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);

    @Override
    Set<Owner> findAll();
}
