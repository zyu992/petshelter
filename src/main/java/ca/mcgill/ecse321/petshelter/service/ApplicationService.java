package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
    public Application createApplication(Integer applicantId, Integer postId, String message){
        if (applicantId == null || postId == null || applicantId <= 0 || postId <= 0){
            throw new IllegalArgumentException();
        }
        if (userService.findById(applicantId) == null || postService.findById(postId) == null){
            throw new EntityNotFoundException();
        }
        Application application = new Application();
        application.setApplicant(userService.findById(applicantId));
        application.setPost(postService.findById(postId));
        application.setMessage(message);
        application.setAccepted(false);
        application.setDate(new Date());
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
        application.setAccepted(true);
        return updateApplication(application);
    }

    @Transactional
    public Application closeApplication(Integer id){
        Application application = applicationMapper.findById(id);
        application.setClosed(true);
        return updateApplication(application);
    }
}
