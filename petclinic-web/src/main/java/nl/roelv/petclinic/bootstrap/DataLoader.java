package nl.roelv.petclinic.bootstrap;

import nl.roelv.petclinic.model.Owner;
import nl.roelv.petclinic.model.PetType;
import nl.roelv.petclinic.model.Vet;
import nl.roelv.petclinic.service.OwnerService;
import nl.roelv.petclinic.service.PetTypeService;
import nl.roelv.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType pt = new PetType();
        pt.setName("Cat");
        PetType savedCat = petTypeService.save(pt);

        pt = new PetType();
        pt.setName("Dog");
        PetType savedDog = petTypeService.save(pt);

        pt = new PetType();
        pt.setName("Mouse");
        petTypeService.save(pt);
        PetType savedDMouse = petTypeService.save(pt);

        pt = new PetType();
        pt.setName("Canary");
        petTypeService.save(pt);
        PetType savedCanary = petTypeService.save(pt);

        System.out.println(petTypeService.findAll().size() + " PetTypes are loaded.");

        Owner o = new Owner();
        o.setFirstName("Roel");
        o.setLastName("Verbunt");
        ownerService.save(o);

        o = new Owner();
        o.setFirstName("John");
        o.setLastName("Doe");
        ownerService.save(o);

        System.out.println(ownerService.findAll().size() + " Owners are loaded.");

        Vet v = new Vet();
        v.setFirstName("Martin");
        v.setLastName("Gauss");
        vetService.save(v);

        v = new Vet();
        v.setFirstName("Paul");
        v.setLastName("Deen");
        vetService.save(v);

        System.out.println(vetService.findAll().size() + " Vets are loaded.");

    }
}
