package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.mapper.PostMapper;
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

    @Autowired
    ApplicationService applicationService;

    @Transactional
    public Post createPost(Integer userId, Integer petId){
        if (userId == null || petId == null || userId <= 0 || petId <= 0){
            throw new IllegalArgumentException("Found Illegal Argument. ");
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

    @Transactional
    public Post confirmAdopter(Integer postId, Integer applicationId){
        if (postId == null || applicationId == null){
            throw new IllegalArgumentException();
        }
        Post post = findById(postId);
        if (post.getAdopter() != null){
            throw new IllegalArgumentException("An adopter has been assigned to this post. ");
        }
        post.setAdopter(applicationService.findById(applicationId).getApplicant());
        post.setClosed(true);
        applicationService.acceptApplication(applicationId);
        for (Application app : post.getApplications()){
            applicationService.closeApplication(app.getApplicationId());
        }
        postMapper.update(post);
        return postMapper.findById(postId);
    }
}
