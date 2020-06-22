package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.dao.PostDao;
import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostDao postDao;

    @Autowired
    UserService userService;

    @Autowired
    PetService petService;

    @Autowired
    ApplicationService applicationService;

    @Transactional
    public void createPost(Post post){
        postDao.save(post);
    }

    @Transactional
    public List<Post> findAllPosts(){
        return postDao.findAll();
    }

    @Transactional
    public Post findById(Integer id) {
        return postDao.findById(id).get();
    }

    @Transactional
    public void confirmAdopter(Integer postId, Integer applicationId){
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
        postDao.save(post);
    }

    @Transactional
    public List<Post> findByUser(Integer userId){
        User user = userService.findById(userId);
        return user.getPosts();
    }

    @Transactional
    public Post findByApplication(Integer applicationId){
        return applicationService.findById(applicationId).getAppliedPost();
    }
}
