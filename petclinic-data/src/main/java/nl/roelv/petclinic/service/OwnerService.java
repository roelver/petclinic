package nl.roelv.petclinic.service;

import nl.roelv.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastname(String lastName);

}
