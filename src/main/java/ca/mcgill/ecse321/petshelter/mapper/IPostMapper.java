package ca.mcgill.ecse321.petshelter.mapper;

import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostMapper {
    List<Post> findAll();

    Post findById(Integer id);

    List<Post> findByUser(User user);

    Integer insert(Post post);
}
