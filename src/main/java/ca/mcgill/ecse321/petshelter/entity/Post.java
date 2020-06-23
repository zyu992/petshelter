package ca.mcgill.ecse321.petshelter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
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
    private Pet PostedPet;

    @Column(name="is_closed", nullable = false)
    private Boolean isClosed;

    @OneToOne
    @JoinColumn(name = "adopter_id")
    private User adopter;

    @OneToMany(mappedBy = "appliedPost", cascade = CascadeType.ALL)
    private List<Application> applications;
}
