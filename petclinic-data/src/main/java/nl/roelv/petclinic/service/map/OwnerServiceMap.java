package nl.roelv.petclinic.service.map;

import nl.roelv.petclinic.model.Owner;
import nl.roelv.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
        return super.save(obj);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
