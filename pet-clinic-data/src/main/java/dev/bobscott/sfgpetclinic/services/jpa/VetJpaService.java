package dev.bobscott.sfgpetclinic.services.jpa;

import dev.bobscott.sfgpetclinic.model.Vet;
import dev.bobscott.sfgpetclinic.repositories.VetRepository;
import dev.bobscott.sfgpetclinic.services.VetService;

import java.util.Set;

public class VetJpaService  implements VetService {

    private final VetRepository vetRepository;

    public VetJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return vetRepository.findAll();
    }
}
