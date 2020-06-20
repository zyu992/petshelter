package ca.mcgill.ecse321.petshelter.entity;

import java.util.Date;
import java.util.List;

public class Post {
    private Integer postId;
    private User postedBy;
    private Date date;
    private Pet pet;
    private Boolean isClosed;
    private User adopter;
    private List<Application> applications;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public User getAdopter() {
        return adopter;
    }

    public void setAdopter(User adopter) {
        this.adopter = adopter;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
