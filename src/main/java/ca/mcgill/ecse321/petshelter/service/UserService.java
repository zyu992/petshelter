package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Transactional
    public User createUser(User user){
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

    @Transactional
    public User update(User user){
        userMapper.update(user);
        return findById(user.getUserId());
    }
}
