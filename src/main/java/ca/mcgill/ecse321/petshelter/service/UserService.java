package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserMapper userMapper;

    @Transactional
    public User createUser(String username, String password, String email){
        if (username == null || password == null || email == null ||
                username.trim().isEmpty() || password.trim().isEmpty() || email.trim().isEmpty()){
            throw new IllegalArgumentException("User information is incomplete. ");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userMapper.insert(user);
        return user;
    }

    @Transactional
    public List<User> findAllUsers(){
        return userMapper.findAll();
    }

    @Transactional
    public User findById(Integer id){
        User user = userMapper.findById(id);
        if (user == null){
            throw new EntityNotFoundException("User requested not found");
        } else return user;
    }
}
