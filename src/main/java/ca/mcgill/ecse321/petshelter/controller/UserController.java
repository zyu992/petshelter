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

    /**
     * Create a User object
     * @param username
     * @param password
     * @param email
     * @return
     */
    @PostMapping("/create")
    public User createUser(@RequestParam("username") String username, @RequestParam("password") String password,
                           @RequestParam("email") String email){
        return userService.createUser(username, password, email);
    }

    /**
     * Find all User objects
     * @return
     */
    @GetMapping("/")
    public List<User> getAllUsers(){
        Gson gson = new Gson();
        String json = gson.toJson(userService.findAllUsers()); 
        return gson.fromJson(json, new TypeToken<List<User>>(){}.getType());
    }

    /**
     * Find a User object with given id.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id){
        Gson gson = new Gson();
        String json = gson.toJson(userService.findById(id));
        return gson.fromJson(json, new TypeToken<User>(){}.getType());
    }

    /**
     * Update a User object.
     * @param user a User object with updated fields
     * @return the User object after update
     */
    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.update(user);
    }

}
