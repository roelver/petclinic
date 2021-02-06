package nl.roelv.petclinic.service.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbstractMapService<T, ID> {

    protected Map<ID, T> data = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(data.values());
    }

    T findById(ID id) {
        return data.get(id);
    }

    T save(ID id,  T obj) {
        data.put(id, obj);
        return obj;
    }

    public void delete(T obj) {
        data.entrySet().removeIf(entry -> entry.getValue().equals(obj));
    }

    public void deleteById(ID id) {
        data.remove(id);
    }
}
