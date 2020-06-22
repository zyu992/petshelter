package ca.mcgill.ecse321.petshelter.dao;

import ca.mcgill.ecse321.petshelter.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostDao extends JpaRepository<Post, Integer>, JpaSpecificationExecutor<Post> {

}
