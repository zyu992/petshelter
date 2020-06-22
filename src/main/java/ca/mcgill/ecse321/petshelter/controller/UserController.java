package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.service.UserService;
import ca.mcgill.ecse321.petshelter.utils.Result;
import ca.mcgill.ecse321.petshelter.utils.ResultCode;
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
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public Result updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        userService.update(id, user);
        return new Result(ResultCode.SUCCESS);
    }
}