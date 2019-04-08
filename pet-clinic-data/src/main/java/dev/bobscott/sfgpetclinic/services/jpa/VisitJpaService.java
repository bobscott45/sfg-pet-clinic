package dev.bobscott.sfgpetclinic.services.jpa;

import dev.bobscott.sfgpetclinic.model.Pet;
import dev.bobscott.sfgpetclinic.model.Visit;
import dev.bobscott.sfgpetclinic.repositories.VisitRepository;
import dev.bobscott.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
@Profile("jpa")
public class VisitJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return visitRepository.findAll();
    }

    @Override
    public void createPetVisit(Pet pet, LocalDate date, String description) {
        Visit visit = new Visit();
        visit.setDate(date);
        visit.setDescription(description);
        visit.setPet(pet);
        save(visit);
        pet.getVisits().add(visit);
    }
}
