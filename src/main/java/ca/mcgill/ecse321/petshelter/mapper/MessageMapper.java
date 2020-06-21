package ca.mcgill.ecse321.petshelter.mapper;

import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.petshelter.entity.Message;

@Repository
public interface MessageMapper {
    
    Iterable<Message> findByRoomId(Integer id);
    
}