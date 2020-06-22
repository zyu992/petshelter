package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.service.UserService;
import ca.mcgill.ecse321.petshelter.utils.Result;
import ca.mcgill.ecse321.petshelter.utils.ResultCode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public Result createUser(@RequestBody User user){
        userService.createUser(user);
        return new Result(ResultCode.SUCCESS);
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

    @PutMapping("/{id}")
    public Result updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        userService.update(id, user);
        return new Result(ResultCode.SUCCESS);
    }
}