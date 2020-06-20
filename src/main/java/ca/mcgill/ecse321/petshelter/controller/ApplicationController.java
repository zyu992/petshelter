package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.mapper.ApplicationMapper;
import ca.mcgill.ecse321.petshelter.service.ApplicationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping("/create")
    public Application createApplication(@Param("applicant") Integer applicantId,
                                         @Param("post") Integer postId,
                                         @Param("message") String message){
        return applicationService.createApplication(applicantId, postId, message);
    }

    @GetMapping("/")
    public List<Application> findAllApplications(){
        return applicationService.findAllApplications();
    }

//    @GetMapping("/")
//    public Application findById(@Param("id") Integer id){
//        return applicationService.findById(id);
//    }
}
