package ca.mcgill.ecse321.petshelter.service;

import ca.mcgill.ecse321.petshelter.entity.Pet;
import ca.mcgill.ecse321.petshelter.entity.Post;
import ca.mcgill.ecse321.petshelter.entity.User;
import ca.mcgill.ecse321.petshelter.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostMapper postMapper;

    @Transactional
    public Post createPost(User user, Pet pet){
        if (user == null || pet == null){
            throw new IllegalArgumentException("Found Illegal Argument. ");
        }
        Post post = new Post();
        post.setPostedBy(user);
        post.setPet(pet);
        post.setDate(new Date());
        postMapper.insert(post);
        return post;
    }

    @Transactional
    public List<Post> findAllPosts(){
        return postMapper.findAll();
    }
}
