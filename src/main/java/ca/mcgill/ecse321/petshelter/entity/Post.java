package ca.mcgill.ecse321.petshelter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Integer postId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "posted_by_id")
    @JsonIgnoreProperties("posts")
    private User postedBy;

    @Column(nullable = false)
    private Date date;

    @OneToOne
    @JoinColumn(name = "posted_pet_id")
    private Pet postedPet;

    @Column(name="is_closed", nullable = false)
    private Boolean isClosed;

    @OneToOne
    @JoinColumn(name = "accpeted_application")
    private Application acceptedApplication;

    @OneToMany(mappedBy = "appliedPost", cascade = CascadeType.ALL)
    private List<Application> applications;

    public Integer getPostId() {return postId;}

    public void setPostId(Integer pPostId) {postId = pPostId;}

    public User getPostedBy() {return postedBy;}

    public void setPostedBy(User pPostedBy) {postedBy = pPostedBy;}

    public Date getDate() {return date;}

    public void setDate(Date pDate) {date = pDate;}

    public Pet getPet() {return postedPet;}

    public void setPet(Pet pPet) {postedPet = pPet;}

    public Boolean getIsClosed() {return isClosed;}

    public void setIsClosed(Boolean pIsClosed) {isClosed = pIsClosed;}

    public Application getAcceptedApplication() {return acceptedApplication;}

    public void setAcceptedApplication(Application pAcceptedApplication) {acceptedApplication = pAcceptedApplication;}

    public List<Application> getApplications() {return applications;}

    public void setApplications(List<Application> pApplications) {applications = pApplications;}
}
