package ru.levelp.at.lesson12.design.patterns.singleton;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class StorageSingletonTest {

    private static final Faker FAKER = new Faker();

    @Test
    void test1() {
        System.out.println("test1");
        Storage.getInstance().put(FAKER.name().firstName(), FAKER.name().lastName());
        Storage.getInstance().put(FAKER.name().firstName(), FAKER.name().lastName());
    }

    @Test
    void test2() {
        System.out.println("test2");
        System.out.println(Storage.getInstance().getAll());
        Storage.getInstance().put(FAKER.name().firstName(), FAKER.name().lastName());
    }

    @Test
    void test3() {
        System.out.println("test3");
        System.out.println(Storage.getInstance().getAll());
    }
}
