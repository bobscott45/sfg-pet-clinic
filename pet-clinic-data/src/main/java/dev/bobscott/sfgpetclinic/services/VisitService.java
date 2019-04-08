package dev.bobscott.sfgpetclinic.services;

import dev.bobscott.sfgpetclinic.model.Pet;
import dev.bobscott.sfgpetclinic.model.Visit;

import java.time.LocalDate;

public interface VisitService extends CrudService<Visit, Long> {

    void createPetVisit(Pet pet, LocalDate date, String description);
}
