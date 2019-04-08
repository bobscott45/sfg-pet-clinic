package dev.bobscott.sfgpetclinic.repositories;

import dev.bobscott.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
    @Override
    Set<Speciality> findAll();
}
