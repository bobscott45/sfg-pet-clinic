package dev.bobscott.sfgpetclinic.services.map;

import dev.bobscott.sfgpetclinic.model.BaseEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if(object == null) {
            throw new RuntimeException("Trying to save a null object");
        }
        if (object.getId() == null) {
            object.setId(getNextId());
        }
        map.put(object.getId(), object);
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(e->e.getValue().equals(object));
    }

    private Long getNextId() {
        return map.keySet().stream().reduce(0L, (x,y)->Math.max(x,y)) + 1;
    }
}
