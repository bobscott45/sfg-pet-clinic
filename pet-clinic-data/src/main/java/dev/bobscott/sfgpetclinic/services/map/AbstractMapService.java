package dev.bobscott.sfgpetclinic.services.map;

import dev.bobscott.sfgpetclinic.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if(object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(e->e.getValue().equals(object));
    }

    private Long getNextId() {
        Set<Long> keyset = map.keySet();
        if(keyset.size() > 0) {
            return Collections.max(keyset) + 1;
        }
        return 1L;
    }
}
