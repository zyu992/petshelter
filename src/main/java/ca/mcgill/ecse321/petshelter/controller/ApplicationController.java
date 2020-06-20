package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.mapper.ApplicationMapper;
import ca.mcgill.ecse321.petshelter.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping("/create")
    public Application createApplication(@RequestParam("applicant") Integer applicantId,
                                         @RequestParam("post") Integer postId,
                                         @RequestParam("message") String message){
        return applicationService.createApplication(applicantId, postId, message);
    }

    @GetMapping("/")
    public List<Application> findAllApplications(){
        return applicationService.findAllApplications();
    }

    @GetMapping("/{id}")
    public Application findById(@PathVariable("id") Integer id){
        return applicationService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Application> findByUser(@PathVariable("userId") Integer id){
        return applicationService.findByUser(id);
    }

    @GetMapping("/post/{postId}")
    public List<Application> findByPost(@PathVariable("postId") Integer id){
        return applicationService.findByPost(id);
    }
}
