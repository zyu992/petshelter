package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.service.UserService;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.google.gson.Gson;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestParam("username") String username, @RequestParam("password") String password,
                           @RequestParam("email") String email){
        return userService.createUser(username, password, email);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        Gson gson = new Gson();
        String json = gson.toJson(userService.findAllUsers()); 
        return gson.fromJson(json, new TypeToken<List<User>>(){}.getType());
    }

}
