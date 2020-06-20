package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.service.PetService;
import ca.mcgill.ecse321.petshelter.service.PostService;
import ca.mcgill.ecse321.petshelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;


    @GetMapping("/")
    public List<Post> getAllPosts(){
        return postService.findAllPosts();
    }

    @PostMapping("/create")
    public Post createPost(@RequestParam("user") Integer userId, @RequestParam("pet") Integer petId){
        return postService.createPost(userId, petId);
    }

//    @GetMapping("/")
//    public Post findById(@RequestParam("id") Integer id){
//        return postService.findById(id);
//    }

}
