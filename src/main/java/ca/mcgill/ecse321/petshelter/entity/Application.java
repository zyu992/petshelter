package ca.mcgill.ecse321.petshelter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue
    @Column(name = "application_id")
    private Integer applicationId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "applied_post_id")
    @JsonIgnoreProperties("applications")
    private Post appliedPost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "applicant_id")
    @JsonIgnoreProperties("applications")
    private User applicant;

    @Column(name = "is_accepted", nullable = false)
    private Boolean isAccepted;

    @Column(name = "is_closed", nullable = false)
    private Boolean isClosed;

    @Column(nullable = false)
    private Date date;

    public Integer getApplicationId() { return applicationId;}

    public void setApplicationId(Integer pApplicationId) {applicationId = pApplicationId;}

    public Post getAppliedPost() { return appliedPost;}

    public void setAppliedPost(Post pAppliedPost){appliedPost = pAppliedPost;}

    public User getApplicant() {return applicant;}

    public void setApplicant(User pApplicant) {applicant = pApplicant;}

    public Boolean getIsAccepted() {return isAccepted;}

    public void setIsAccepted(Boolean pIsAccepted) {isAccepted = pIsAccepted;}

    public Boolean getIsClosed() {return isClosed;}

    public void setIsClosed(Boolean pIsClosed) {isClosed = pIsClosed;}

    public Date getDate(){return date;}

    public void setDate(Date pDate) {date = pDate;}
}
