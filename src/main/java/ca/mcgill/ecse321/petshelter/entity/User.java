package ca.mcgill.ecse321.petshelter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer userId;

    @Column(nullable = false)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "applicant")
    @JsonIgnoreProperties("applicant")
    private List<Application> applications;

    @OneToMany(mappedBy = "postedBy")
    @JsonIgnoreProperties("postedBy")
    private List<Post> posts;

    @OneToMany(mappedBy = "payer")
    @JsonIgnoreProperties("payer")
    private List<Payment> payments;

    @OneToMany(mappedBy = "sender")
    @JsonIgnoreProperties("sender")
    private List<Message> sentMessages;

    @ManyToMany(mappedBy = "rooms")
    @JsonIgnoreProperties("rooms")
    private List<Room> rooms;

    public Integer getUserId() {return userId;}

    public void setUserId(Integer pUserId) {userId = pUserId;}

    public String getUsername() {return username;}

    public void setUsername(String pUsername) {username = pUsername;}

    public String getPassword() {return password;}

    public void setPassword(String pPassword) {password = pPassword;}

    public String getEmail() {return email;}

    public void setEmail(String pEmail) {email = pEmail;}

    public List<Application> getApplications() {return applications;}

    public void setApplications(List<Application> pApplications) {applications = pApplications;}

    public List<Post> getPosts() {return posts;}

    public void setPosts(List<Post> pPosts) {posts = pPosts;}

    public List<Payment> getPayments() {return payments;}

    public void setPayments(List<Payment> pPayments) {payments = pPayments;}

    public List<Message> getMessages() {return sentMessages;}

    public void setMessages(List<Message> pMessages) {sentMessages = pMessages;}

    public List<Room> getRooms() {return rooms;}

    public void setRooms(List<Room> pRooms) {rooms = pRooms;}
}
