package dev.bobscott.sfgpetclinic.repositories;

import dev.bobscott.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VisitRepository extends CrudRepository<Visit, Long> {
    @Override
    Set<Visit> findAll();
}
