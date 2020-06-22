package ca.mcgill.ecse321.petshelter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User {
    private Integer userId;
    private String username;
    private transient String password;
    private String email;
    private List<Application> applications;
    private List<Post> posts;
}
