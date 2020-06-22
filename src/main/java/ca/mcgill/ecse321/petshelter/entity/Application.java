package ca.mcgill.ecse321.petshelter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Application {
    private Integer applicationId;
    private Post post;
    private User applicant;
    private String message;
    private Boolean isAccepted;
    private Boolean isClosed;
    private Date date;
}
