package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public void createUser(User user){
        userDao.save(user);
    }

    @Transactional
    public List<User> findAllUsers(){
        return userDao.findAll();
    }

    @Transactional
    public User findById(Integer id){
        User user = userDao.findById(id).get();
        if (user == null){
            throw new EntityNotFoundException("User requested not found");
        } else return user;
    }

    @Transactional
    public void update(Integer id, User user){
        User temp = userDao.findById(id).get();
        temp.setUsername(user.getUsername());
        temp.setPassword(user.getPassword());
        temp.setEmail(user.getEmail());
        userDao.save(temp);
    }
}
