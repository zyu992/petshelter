package ca.mcgill.ecse321.petshelter.controller;

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

    /**
     * Create a new Post.
     * @param userId
     * @param petId
     * @return
     */
    @PostMapping("/create")
    public Post createPost(@RequestParam("user") Integer userId, @RequestParam("pet") Integer petId){
        return postService.createPost(userId, petId);

    }

    /**
     * Find all Posts.
     * @return
     */
    @GetMapping("/")
    public List<Post> getAllPosts(){
        return postService.findAllPosts();
    }

    /**
     * Find Post with the given id.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Integer id){
        return postService.findById(id);
    }

    @PutMapping("/assign")
    public Post assignAdopter(@RequestParam("post") Integer postId, @RequestParam("application") Integer applicationId){
        return postService.confirmAdopter(postId, applicationId);
    }
}
