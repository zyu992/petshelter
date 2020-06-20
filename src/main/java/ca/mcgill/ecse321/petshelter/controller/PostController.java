package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Application;
import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.service.PetService;
import ca.mcgill.ecse321.petshelter.service.PostService;
import ca.mcgill.ecse321.petshelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> 8952fac3e29b9f57927a125b0cbc1501807c98ed

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;


    @GetMapping("/")
    public String getAllPosts(){
        return new Gson().toJson(postService.findAllPosts());
    }

    @PostMapping("/create")
    public Post createPost(@Param("userId") Integer userId, @Param("petId") Integer petId){
        return postService.createPost(userId, petId);
        // HashMap<String, Object> map = new HashMap<>();
        // map.put("code", 202);
        // map.put("postId", p.getPostId());
        // map.put("userId", p.getPostedBy().getUserId());
        // map.put("date",p.getDate());
        // map.put("pet",p.getPet());
        // map.put("adopter", p.getAdopter());
        // map.put("applications", p.getApplications());
        // map.put("closed", false);
        // return map;
    }

//    @GetMapping("/")
//    public Post findById(@RequestParam("id") Integer id){
//        return postService.findById(id);

//    }

}
