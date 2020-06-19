package ca.mcgill.ecse321.petshelter.entity;

public class Pet {
    private Integer petId;
    private String petName;
    private Integer age;
    private Species species;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
