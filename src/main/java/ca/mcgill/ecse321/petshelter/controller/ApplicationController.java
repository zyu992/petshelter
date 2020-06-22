package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.service.ApplicationService;
import ca.mcgill.ecse321.petshelter.utils.Result;
import ca.mcgill.ecse321.petshelter.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping
    public Result createApplication(@RequestBody Application application){
        applicationService.createApplication(application);
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping
    public List<Application> findAll(){
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
