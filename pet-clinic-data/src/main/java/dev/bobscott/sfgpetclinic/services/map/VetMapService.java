package dev.bobscott.sfgpetclinic.services.map;

import dev.bobscott.sfgpetclinic.model.Speciality;
import dev.bobscott.sfgpetclinic.model.Vet;
import dev.bobscott.sfgpetclinic.services.SpecialtyService;
import dev.bobscott.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile({"default, map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        saveSpecialitiesWithNullId(object.getSpecialities());
        return super.save(object);
    }

    private void saveSpecialitiesWithNullId(Set<Speciality> specialities) {
        specialities.stream()
            .filter(s->s.getId() == null)
            .forEach(s->specialtyService.save(s));
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }
}
