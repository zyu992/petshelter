package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.service.PostService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/create")
    public Post createPost(@Param("userId") Integer userId, @Param("petId") Integer petId){
        return postService.createPost(userId, petId);

    }

    @GetMapping("/")
    public String getAllPosts(){
        return new Gson().toJson(postService.findAllPosts());
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Integer id){
        return postService.findById(id);
    }

}
