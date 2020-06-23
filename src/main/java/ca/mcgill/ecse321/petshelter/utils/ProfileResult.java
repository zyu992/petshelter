package ca.mcgill.ecse321.petshelter.utils;


import ca.mcgill.ecse321.petshelter.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProfileResult {
    private String username;
    private String email;

    public ProfileResult(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
