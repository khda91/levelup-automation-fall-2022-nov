package ru.levelp.at.lesson0809.api.serialization.deserialization.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Boolean gender;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth, Boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{"
            + "firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", dateOfBirth=" + dateOfBirth
            + ", gender=" + gender
            + '}';
    }
}
