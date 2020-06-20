package ca.mcgill.ecse321.petshelter.mapper;

import ca.mcgill.ecse321.petshelter.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper {

    List<User> findAll();

    User findById(Integer id);

    List<User> findByUsername(String username);

    int insert(User user);

    int update(User user);
}
