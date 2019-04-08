package dev.bobscott.sfgpetclinic.services.jpa;

import dev.bobscott.sfgpetclinic.model.Pet;
import dev.bobscott.sfgpetclinic.repositories.PetRepository;
import dev.bobscott.sfgpetclinic.services.PetService;

import java.util.Set;

public class PetTypeJpaService implements PetService {

    private final PetRepository petRepository;

    public PetTypeJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return petRepository.findAll();
    }
}
