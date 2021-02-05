package nl.roelv.petclinic.service;

import nl.roelv.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastname(String lasName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
