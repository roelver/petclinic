package nl.roelv.petclinic.service.map;

import nl.roelv.petclinic.model.Specialty;
import nl.roelv.petclinic.model.Vet;
import nl.roelv.petclinic.service.SpecialtyService;
import nl.roelv.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet obj) {
        if (obj != null) {
            if (obj.getSpecialties() != null) {
                obj.getSpecialties().forEach(spec -> {
                    if (spec.getId() == null) {
                        Specialty savedSpec = specialtyService.save(spec);
                        spec.setId(savedSpec.getId());
                    }
                });
            }
            return super.save(obj);
        }
        return null;
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
