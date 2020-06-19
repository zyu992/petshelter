package ca.mcgill.ecse321.petshelter.mapper;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface IApplicationMapper {

    List<Application> findAll();

    Application findById(Integer id);

    List<Application> findByUser(User user);

    List<Application> findByPost(Post post);

    Integer insert(Application application);
}
