package dev.bobscott.sfgpetclinic.services.map;

import dev.bobscott.sfgpetclinic.model.Owner;
import dev.bobscott.sfgpetclinic.model.Pet;
import dev.bobscott.sfgpetclinic.services.OwnerService;
import dev.bobscott.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {


    private final PetService petService;

    public OwnerMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner save(Owner object) {
        if(object != null) {
            savePets(object.getPets());
        }
        return super.save(object);
    }

    private void savePets(Set<Pet> pets) {
        if(pets == null) return;
        pets.stream()
            .filter(p -> p.getId() == null)
            .forEach(p-> petService.save(p));
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }


}
