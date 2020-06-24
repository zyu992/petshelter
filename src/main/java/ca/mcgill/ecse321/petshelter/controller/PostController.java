package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.service.PostService;
import ca.mcgill.ecse321.petshelter.utils.Result;
import ca.mcgill.ecse321.petshelter.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public Result createPost(@RequestBody Post post){
        postService.createPost(post);
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping
    public Result findAll(){
        return new Result(ResultCode.SUCCESS, postService.findAllPosts());
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id){
        return new Result(ResultCode.SUCCESS, postService.findById(id));
    }

    @PutMapping("/assign")
    public Result assignAdopter(@RequestParam("post") Integer postId, @RequestParam("application") Integer applicationId){
        postService.confirmAdopter(postId, applicationId);
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping("/user/{userId}")
    public Result findByUser(@PathVariable("userId") Integer id){
        return new Result(ResultCode.SUCCESS, postService.findByUser(id));
    }

    @GetMapping("/application/{applicationId}")
    public Result findByApplication(@PathVariable("applicationId") Integer id){
        return new Result(ResultCode.SUCCESS, postService.findByApplication(id));
    }
}
