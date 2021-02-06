package nl.roelv.petclinic.service.map;

import nl.roelv.petclinic.model.Vet;
import nl.roelv.petclinic.service.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet obj) {
        return super.save(obj.getId(), obj);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Vet obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
