package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PetMapper petMapper;

    @Autowired
    PostService postService;

    @Transactional
    public Pet createPet(String name, Integer age, String species) {
        if (name == null || age == null || species == null ||
                name.trim().isEmpty() || species.trim().isEmpty() || age < 0) {
            throw new IllegalArgumentException();
        }
        Pet pet = new Pet();
        pet.setPetName(name);
        pet.setAge(age);
        pet.setSpecies(species);
        petMapper.insert(pet);
        return pet;
    }

    @Transactional
    public Pet findById(Integer petId) {
        return petMapper.findById(petId);
    }

    @Transactional
    public List<Pet> findAllPets() {
        return petMapper.findAll();
    }

    @Transactional
    public Pet findByPost(Integer postId) {
        Post post = postService.findById(postId);
        return findById(post.getPet().getPetId());
    }
}
