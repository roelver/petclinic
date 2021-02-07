package nl.roelv.petclinic.service.map;

import nl.roelv.petclinic.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> data = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(data.values());
    }

    T findById(ID id) {
        return data.get(id);
    }

    public T save(T obj) {
        if (obj == null) {
            throw new RuntimeException("No object was passed to save");
        }
        if (obj.getId() == null) {
            Long id = getNextId();
            obj.setId(id);
        }
        data.put(obj.getId(), obj);
        return obj;
    }

    public void delete(T obj) {
        data.entrySet().removeIf(entry -> entry.getValue().equals(obj));
    }

    public void deleteById(ID id) {
        data.remove(id);
    }


    private Long getNextId() {
        if (data.size() == 0) {
            return 1L;
        }
        return Collections.max(data.keySet()) + 1;
    }
}
