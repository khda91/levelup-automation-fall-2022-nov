package ru.levelp.at.lesson12.design.patterns.builder;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

class PersonBuilderTest {

    private static final Faker FAKER = new Faker();

    @Test
    void test1() {
        System.out.println(Person.builder().build());
    }

    @Test
    void test2() {
        System.out.println(Person.builder()
                                 .firstName(FAKER.name().firstName())
                                 .build());
    }

    @Test
    void test3() {
        System.out.println(Person.builder()
                                 .firstName(FAKER.name().firstName())
                                 .gender("MALE")
                                 .build());
    }

    @Test
    void test4() {
        System.out.println(Person.builder()
                                 .lastName(FAKER.name().lastName())
                                 .gender("MALE")
                                 .build());
    }

    @Test
    void test5() {
        System.out.println(Person.builder()
                                 .lastName(FAKER.name().lastName())
                                 .firstName(FAKER.name().firstName())
                                 .build());
    }
}
