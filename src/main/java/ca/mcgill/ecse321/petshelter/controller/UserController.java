package ca.mcgill.ecse321.petshelter.controller;

import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.service.UserService;
import ca.mcgill.ecse321.petshelter.utils.Result;
import ca.mcgill.ecse321.petshelter.utils.ResultCode;
import ca.mcgill.ecse321.petshelter.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users/")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    TokenUtil tokenUtil;

    @PostMapping("register")
    public Result createUser(@RequestBody User user){
        userService.createUser(user);
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping
    public Result getAllUsers(){
        List<User> users = userService.findAllUsers();
        return new Result(ResultCode.SUCCESS, users);
    }

    @GetMapping("{id}")
    public Result findById(@PathVariable("id") Integer id){
        return new Result(ResultCode.SUCCESS, userService.findById(id));
    }

    @PutMapping("{id}")
    public Result updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        userService.update(id, user);
        return new Result(ResultCode.SUCCESS);
    }

    @PostMapping("login")
    public Result login(@RequestBody Map<String, String> loginMap){
        User user = userService.findByUsername(loginMap.get("username"));
        if (user == null || !user.getPassword().equals(loginMap.get("password"))){
            return new Result(ResultCode.USERNAME_OR_PASSWORD_ERROR);
        }
        String token = tokenUtil.generateJWT(user.getUserId(), user.getUsername(), new HashMap<String, Object>());
        Map <Object, Object> map = new HashMap<>();
        map.put("user",user);
        map.put("token",token);
        return new Result(ResultCode.SUCCESS, map);
    }
}
