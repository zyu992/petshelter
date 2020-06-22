package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.service.PostService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);

    }

    @GetMapping("/")
    public List<Post> getAllPosts(){
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Integer id){
        return postService.findById(id);
    }

    @PutMapping("/assign")
    public Post assignAdopter(@RequestParam("post") Integer postId, @RequestParam("application") Integer applicationId){
        return postService.confirmAdopter(postId, applicationId);
    }

    @GetMapping("/user/{userId}")
    public List<Post> findByUser(@PathVariable("userId") Integer id){
        return postService.findByUser(id);
    }

    @GetMapping("/application/{applicationId}")
    public Post findByApplication(@PathVariable("applicationId") Integer id){
        return postService.findByApplication(id);
    }
}
