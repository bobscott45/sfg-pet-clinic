package dev.bobscott.sfgpetclinic.services.map;

import dev.bobscott.sfgpetclinic.model.Pet;
import dev.bobscott.sfgpetclinic.model.PetType;
import dev.bobscott.sfgpetclinic.services.PetService;
import dev.bobscott.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default, map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    private PetTypeService petTypeService;

    public PetMapService(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        if(object != null) {
            petTypeService.save(object.getPetType());
        }
        return super.save(object);
    }

    private void savePetTypeWithNullId(PetType petType) {
        if(petType.getId() == null) {
            petTypeService.save(petType);
        }
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }
}
