package dev.bobscott.sfgpetclinic.repositories;

import dev.bobscott.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
