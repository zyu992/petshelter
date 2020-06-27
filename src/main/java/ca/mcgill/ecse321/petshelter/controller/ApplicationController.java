package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.service.ApplicationService;
import ca.mcgill.ecse321.petshelter.utils.Result;
import ca.mcgill.ecse321.petshelter.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping("/create")
    public Result createApplication(@RequestBody Application application){
        applicationService.createApplication(application);
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping
    public Result findAll(){
        return new Result(ResultCode.SUCCESS, applicationService.findAllApplications());
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id){
        return new Result(ResultCode.SUCCESS, applicationService.findById(id));
    }

    @GetMapping("/user/{userId}")
    public Result findByUser(@PathVariable("userId") Integer id){
        return new Result(ResultCode.SUCCESS, applicationService.findByUser(id));
    }

    @GetMapping("/post/{postId}")
    public Result findByPost(@PathVariable("postId") Integer id){
        return new Result(ResultCode.SUCCESS, applicationService.findByPost(id));
    }
}
