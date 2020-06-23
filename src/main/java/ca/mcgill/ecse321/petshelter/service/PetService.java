package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.dao.PetDao;
import ca.mcgill.ecse321.petshelter.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PetDao petDao;

    @Autowired
    PostService postService;

    @Transactional
    public void createPet(Pet pet) {
        petDao.save(pet);
    }

    @Transactional
    public Pet findById(Integer id) {
        return petDao.findById(id).get();
    }

    @Transactional
    public List<Pet> findAllPets() {
        return petDao.findAll();
    }

    @Transactional
    public Pet findByPost(Integer postId) {
        return postService.findById(postId).getPostedPet();
    }
}
