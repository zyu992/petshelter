package ca.mcgill.ecse321.petshelter.mapper;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.entity.Species;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetMapper {
    List<Pet> findAll();

    Pet findById(Integer id);

    Pet findBySpecies(Species species);

    Integer insert(Pet pet);
}
