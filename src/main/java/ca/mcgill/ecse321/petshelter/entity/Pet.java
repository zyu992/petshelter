package ca.mcgill.ecse321.petshelter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pet {
    private Integer petId;
    private String petName;
    private Integer age;
    private String species;
}
