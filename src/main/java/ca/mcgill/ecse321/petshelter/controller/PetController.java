package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.service.PetService;
import ca.mcgill.ecse321.petshelter.utils.Result;
import ca.mcgill.ecse321.petshelter.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping("/create")
    public Result createPet(@RequestBody Pet pet){
        petService.createPet(pet);
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping
    public Result getAllPets(){
        return new Result(ResultCode.SUCCESS, petService.findAllPets());
    }

    @GetMapping("/{id}}")
    public Result findById(@PathVariable("id") Integer id){
        return new Result(ResultCode.SUCCESS, petService.findById(id));
    }

    @GetMapping("/post/{postId}")
    public Result getPet(@PathVariable("postId") Integer id) {
        return new Result(ResultCode.SUCCESS, petService.findByPost(id));
    }
}
