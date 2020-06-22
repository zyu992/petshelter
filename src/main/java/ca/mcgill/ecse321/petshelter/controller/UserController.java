package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.service.UserService;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.google.gson.Gson;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        Gson gson = new Gson();
        String json = gson.toJson(userService.findAllUsers()); 
        return gson.fromJson(json, new TypeToken<List<User>>(){}.getType());
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id){
        Gson gson = new Gson();
        String json = gson.toJson(userService.findById(id));
        return gson.fromJson(json, new TypeToken<User>(){}.getType());
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.update(user);
    }
}