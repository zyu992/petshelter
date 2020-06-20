package ca.mcgill.ecse321.petshelter.mapper;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetMapper {
    List<Pet> findAll();

    Pet findById(Integer id);

    Integer insert(Pet pet);
}
