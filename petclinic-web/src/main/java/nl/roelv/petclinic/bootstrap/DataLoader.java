package nl.roelv.petclinic.bootstrap;

import nl.roelv.petclinic.model.*;
import nl.roelv.petclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = vetService.findAll().size();
        if (count == 0) {
            loadAllData();
        }
    }

    private void loadAllData() {
        System.out.println("Loading data...");

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

        Specialty euth = new Specialty();
        euth.setDescription("Euthanasia" );
        Specialty savedEuth = specialtyService.save(euth);

        Specialty dent = new Specialty();
        dent.setDescription("Detistry" );
        Specialty savedDent = specialtyService.save(dent);

        Specialty surg = new Specialty();
        surg.setDescription("Surgery" );
        Specialty savedSurg = specialtyService.save(surg);

        System.out.println(specialtyService.findAll().size() + " Specialties are loaded.");

        Owner o = new Owner();
        o.setFirstName("Roel");
        o.setLastName("Verbunt");
        o.setAddress("Jan van Eyckstraat 18");
        o.setAddress("Oisterwijk");
        o.setTelephone("71247512");

        Pet skit = new Pet();
        skit.setName("Skittle");
        skit.setPetType(savedCat);
        skit.setBirthDate(LocalDate.now());
        skit.setOwner(o);
        o.getPets().add(skit);

        Pet hum = new Pet();
        hum.setName("Hummer");
        hum.setPetType(savedCat);
        hum.setBirthDate(LocalDate.now());
        hum.setOwner(o);
        o.getPets().add(hum);

        ownerService.save(o);

        o = new Owner();
        o.setFirstName("John");
        o.setLastName("Doe");
        o.setLastName("12 Main street");
        o.setLastName("Springfield");
        o.setTelephone("38562378");

        Pet nero = new Pet();
        nero.setName("Nero");
        nero.setPetType(savedDog);
        nero.setBirthDate(LocalDate.now());
        nero.setOwner(o);
        o.getPets().add(nero);

        ownerService.save(o);

        System.out.println(ownerService.findAll().size() + " Owners are loaded.");

        Vet v = new Vet();
        v.setFirstName("Martin");
        v.setLastName("Gauss");

        v.getSpecialties().add(savedEuth);
        v.getSpecialties().add(savedSurg);
        vetService.save(v);

        v = new Vet();
        v.setFirstName("Paul");
        v.setLastName("Deen");
        v.getSpecialties().add(savedSurg);
        v.getSpecialties().add(savedDent);
        vetService.save(v);

        System.out.println(vetService.findAll().size() + " Vets are loaded.");
    }
}
