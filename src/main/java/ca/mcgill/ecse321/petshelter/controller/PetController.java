package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetService petService;

    @GetMapping("/")
    public List<Pet> getAllPets(){
        return petService.findAllPets();
    }

    @PostMapping("/create")
    public Pet createPet(@RequestParam("name") String name,
                         @RequestParam("age") Integer age,
                         @RequestParam("species") String species){
        return petService.createPet(name, age, species);
    }

//    @GetMapping("/get")
//    public Pet findById(@RequestParam("id") Integer id){
//        return petService.findById(id);
//    }
}
