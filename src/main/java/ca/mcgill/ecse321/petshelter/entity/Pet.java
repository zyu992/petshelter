package ca.mcgill.ecse321.petshelter.entity;

import javax.persistence.*;

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

    public Integer getPetId() {return petId;}

    public void setPetId(Integer pPetId) {petId = pPetId;}

    public String getPetName() {return petName;}

    public void setPetName(String pPetName) {petName = pPetName;}

    public Integer getAge() {return age;}

    public void setAge(Integer pAge){age = pAge;}

    public String getSpecies(){return species;}

    public void setSpecies(String pSpecies) {species = pSpecies;}
}
