package ca.mcgill.ecse321.petshelter.mapper;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ApplicationMapper {

    List<Application> findAll();

    Application findById(Integer id);

    Application findByUserAndPost(@Param("user") Integer userId, @Param("post") Integer postId);

    int insert(Application application);

    int update(Application application);
}
