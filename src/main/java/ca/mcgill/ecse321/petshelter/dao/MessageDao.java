package ca.mcgill.ecse321.petshelter.dao;

import ca.mcgill.ecse321.petshelter.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MessageDao extends JpaRepository<Message, Integer>, JpaSpecificationExecutor<Message> {
}