package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.dao.ApplicationDao;
import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    ApplicationDao applicationDao;

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @Transactional
    public List<Application> findAllApplications(){
        return applicationDao.findAll();
    }

    @Transactional
    public Application findById(Integer id){
        return applicationDao.findById(id).get();
    }

    @Transactional
    public void createApplication(Application application){
        application.setIsClosed(false);
        application.setIsAccepted(false);
        application.setDate(new Date());
        applicationDao.save(application);
    }

    @Transactional
    public void acceptApplication(Integer id){
        Application application = applicationDao.findById(id).get();
        application.setIsAccepted(true);
        applicationDao.save(application);
    }

    @Transactional
    public void closeApplication(Integer id){
        Application application = applicationDao.findById(id).get();
        application.setIsClosed(true);
        applicationDao.save(application);
    }

    @Transactional
    public List<Application> findByUser(Integer userId){
        User user = userService.findById(userId);
        List<Application> applications = new ArrayList<>();
        return user.getApplications();
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
