package nl.roelv.petclinic.service.map;

import nl.roelv.petclinic.model.Owner;
import nl.roelv.petclinic.model.Pet;
import nl.roelv.petclinic.service.OwnerService;
import nl.roelv.petclinic.service.PetService;
import nl.roelv.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastname(String lastName) {
        for (Owner o : data.values() ) {
            if (o.getLastName().equalsIgnoreCase(lastName)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner obj) {
        if (obj != null) {
            if (obj.getPets() != null) {
                obj.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else {
                        throw new RuntimeException("Pet must have a type");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(obj);
        }
        return null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
