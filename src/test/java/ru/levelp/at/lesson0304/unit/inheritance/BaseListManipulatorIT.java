package ru.levelp.at.lesson0304.unit.inheritance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.levelp.at.lesson0304.unit.ListManipulator;
import ru.levelp.at.lesson0304.unit.ListManipulatorImpl;

public abstract class BaseListManipulatorIT {

    protected ListManipulator manipulator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
        manipulator = new ListManipulatorImpl();
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
        manipulator = null;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }
}
