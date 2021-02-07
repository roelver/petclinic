package nl.roelv.petclinic.bootstrap;

import nl.roelv.petclinic.model.Owner;
import nl.roelv.petclinic.model.Vet;
import nl.roelv.petclinic.service.OwnerService;
import nl.roelv.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
