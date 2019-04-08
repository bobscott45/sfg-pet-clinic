package dev.bobscott.sfgpetclinic.services.map;

import dev.bobscott.sfgpetclinic.model.Pet;
import dev.bobscott.sfgpetclinic.model.Visit;
import dev.bobscott.sfgpetclinic.services.PetService;
import dev.bobscott.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    private final PetService petService;

    public VisitMapService(PetService petService) {
        this.petService = petService;
    }


    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        savePetWithNullId(object.getPet());
        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    private void savePetWithNullId(Pet pet) {
        if(pet.getId() == null) {
            petService.save(pet);
        }
    }
}
