package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetService {

    @Autowired
    PetMapper petMapper;

    @Transactional
    public Pet findById(Integer petId){
        return petMapper.findById(petId);
    }
}
