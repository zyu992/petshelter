package ca.mcgill.ecse321.petshelter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue
    @Column(name = "application_id")
    private Integer applicationId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "applied_post_id")
    private Post appliedPost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "applicant_id")
    private User applicant;

    private String message;

    @Column(name = "is_accepted", nullable = false)
    private Boolean isAccepted;

    @Column(name = "is_closed", nullable = false)
    private Boolean isClosed;

    @Column(nullable = false)
    private Date date;
}
