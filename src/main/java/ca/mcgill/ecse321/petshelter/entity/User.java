package ca.mcgill.ecse321.petshelter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    @OneToMany(mappedBy = "receiver")
    @JsonIgnoreProperties("receiver")
    private List<Message> receivedMessages;

}
