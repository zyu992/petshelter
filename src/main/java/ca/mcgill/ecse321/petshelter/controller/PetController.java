package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.service.PetService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Pet createPet(@Param("name") String name,
                         @Param("age") Integer age,
                         @Param("species") String species){
        return petService.createPet(name, age, species);
    }

//    @GetMapping("/get")
//    public Pet findById(@Param("id") Integer id){
//        return petService.findById(id);
//    }
}
