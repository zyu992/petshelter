package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.mapper.PostMapper;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    @Autowired
    UserService userService;

    @Autowired
    PetService petService;

    @Transactional
    public Post createPost(Integer userId, Integer petId){
        if (userId == null || petId == null || userId <= 0 || petId <= 0){
            throw new IllegalArgumentException("Found Illegal Argument. ");
        }
        if (userService.findById(userId) == null || petService.findById(petId) == null){
            throw new EntityNotFoundException();
        }
        Post post = new Post();
        post.setPostedBy(userService.findById(userId));
        post.setPet(petService.findById(petId));
        post.setDate(new Date());
        postMapper.insert(post);
        return post;
    }

    @Transactional
    public List<Post> findAllPosts(){
        return postMapper.findAll();
    }

    @Transactional
    public Post findById(Integer id) {
        return postMapper.findById(id);
    }
}
