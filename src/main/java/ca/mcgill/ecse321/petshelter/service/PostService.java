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
import java.util.ArrayList;
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
    public Post createPost(Post post){
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
            throw new IllegalArgumentException("An adopter has already been assigned to this post. ");
        }
        post.setAdopter(applicationService.findById(applicationId).getApplicant());
        post.setIsClosed(true);
        applicationService.acceptApplication(applicationId);
        for (Application app : post.getApplications()){
            applicationService.closeApplication(app.getApplicationId());
        }
        postMapper.update(post);
        return postMapper.findById(postId);
    }

    @Transactional
    public List<Post> findByUser(Integer userId){
        User user = userService.findById(userId);
        List<Post> posts = new ArrayList<>();
        for (Post post : user.getPosts()){
            posts.add(findById(post.getPostId()));
        }
        return posts;
    }



    @Transactional
    public Post findByApplication(Integer applicationId){
        Application application = applicationService.findById(applicationId);
        return findById(application.getPost().getPostId());
    }
}
