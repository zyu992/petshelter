package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @Transactional
    public List<Application> findAllApplications(){
        return applicationMapper.findAll();
    }

    @Transactional
    public Application findById(Integer id){
        return applicationMapper.findById(id);
    }

    @Transactional
    public Application createApplication(Application application){
        applicationMapper.insert(application);
        return application;
    }

    @Transactional
    public Application findByUserAndPost(Integer userId, Integer postId){
        return applicationMapper.findByUserAndPost(userId, postId);
    }

    @Transactional
    public Application updateApplication(Application application){
        applicationMapper.update(application);
        return applicationMapper.findById(application.getApplicationId());
    }

    @Transactional
    public Application acceptApplication(Integer id){
        Application application = applicationMapper.findById(id);
        application.setIsAccepted(true);
        return updateApplication(application);
    }

    @Transactional
    public Application closeApplication(Integer id){
        Application application = applicationMapper.findById(id);
        application.setIsClosed(true);
        return updateApplication(application);
    }

    @Transactional
    public List<Application> findByUser(Integer userId){
        User user = userService.findById(userId);
        List<Application> applications = new ArrayList<>();
        for (Application application : user.getApplications()){
            applications.add(findById(application.getApplicationId()));
        }
        return applications;
    }

    @Transactional
    public List<Application> findByPost(Integer postId){
        List<Application> applications = new ArrayList<>();
        Post post = postService.findById(postId);
        for (Application application : post.getApplications()){
            applications.add(findById(application.getApplicationId()));
        }
        return applications;
    }
}
