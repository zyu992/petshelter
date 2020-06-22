package ca.mcgill.ecse321.petshelter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Post {
    private Integer postId;
    private User postedBy;
    private Date date;
    private Pet pet;
    private Boolean isClosed;
    private User adopter;
    private List<Application> applications;
}
