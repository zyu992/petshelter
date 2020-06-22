package ca.mcgill.ecse321.petshelter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
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
    private User postedBy;

    @Column(nullable = false)
    private Date date;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "posted_pet_id")
    private Pet PostedPet;

    @Column(name="is_closed", nullable = false)
    private Boolean isClosed;

    @ManyToOne(optional = false)
    @JoinColumn(name = "adopter_id")
    private User adopter;

    @OneToMany(mappedBy = "appliedPost", cascade = CascadeType.ALL)
    private List<Application> applications;
}
