package ru.levelp.at.lesson12.design.patterns.builder;

import java.time.LocalDate;

public class PersonProblem {

    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dateOfBirth;
    private String gender;

    //    public Person(String lastName, String middleName, LocalDate dateOfBirth, String gender) {
    //        this(null, lastName, middleName, dateOfBirth, gender);
    //    }

    public PersonProblem(String firstName, String lastName, LocalDate dateOfBirth) {
        this(firstName, lastName, null, dateOfBirth, null);
    }

    public PersonProblem(String firstName, String lastName, LocalDate dateOfBirth, String gender) {
        this(firstName, lastName, null, dateOfBirth, gender);
    }

    public PersonProblem(String firstName, String lastName, String middleName, LocalDate dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
}
