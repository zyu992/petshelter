package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.service.PetService;
import ca.mcgill.ecse321.petshelter.service.PostService;
import ca.mcgill.ecse321.petshelter.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @Autowired
    PetService petService;

    @GetMapping("/")
    public List<Post> getAllPosts(){
        return postService.findAllPosts();
    }

    @PostMapping("/create")
    public Post createPost(@Param("user") Integer userId, @Param("pet") Integer petId){
        User user = userService.findById(userId);
        Pet pet = petService.findById(petId);
        return postService.createPost(user, pet);
    }


}
