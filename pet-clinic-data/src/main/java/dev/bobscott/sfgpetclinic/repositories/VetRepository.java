package dev.bobscott.sfgpetclinic.repositories;

import dev.bobscott.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VetRepository extends CrudRepository<Vet, Long> {
    @Override
    Set<Vet> findAll();
}
