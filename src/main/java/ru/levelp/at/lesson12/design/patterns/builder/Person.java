package ru.levelp.at.lesson12.design.patterns.builder;

import java.time.LocalDate;

public class Person {

    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final LocalDate dateOfBirth;
    private final String gender;

    public Person(String firstName, String lastName, String middleName, LocalDate dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    @Override
    public String toString() {
        return "Person{" +
            "firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", middleName='" + middleName + '\''
            + ", dateOfBirth=" + dateOfBirth
            + ", gender='" + gender + '\''
            + '}';
    }

    static class PersonBuilder {

        private String firstName;
        private String lastName;
        private String middleName;
        private LocalDate dateOfBirth;
        private String gender;

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PersonBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(firstName, lastName, middleName, dateOfBirth, gender);
        }
    }
}
