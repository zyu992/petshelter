package ca.mcgill.ecse321.petshelter.dao;

import ca.mcgill.ecse321.petshelter.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ApplicationDao extends JpaRepository<Application, Integer>, JpaSpecificationExecutor<Application> {
}
