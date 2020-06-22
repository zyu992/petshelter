package ca.mcgill.ecse321.petshelter.dao;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PetDao extends JpaRepository<Pet, Integer>, JpaSpecificationExecutor<Pet> {
}
