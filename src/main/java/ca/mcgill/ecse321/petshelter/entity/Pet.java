package ca.mcgill.ecse321.petshelter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Integer petId;

    @Column(name = "pet_name", nullable = false)
    private String petName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String species;
}
