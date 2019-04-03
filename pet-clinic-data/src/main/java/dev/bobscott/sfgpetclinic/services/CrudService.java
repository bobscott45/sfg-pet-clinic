package dev.bobscott.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    T findById(ID id);
    T save(T object, ID id);
    void delete(T object);
    void deleteById(ID id);
    Set<T> findAll();


}
