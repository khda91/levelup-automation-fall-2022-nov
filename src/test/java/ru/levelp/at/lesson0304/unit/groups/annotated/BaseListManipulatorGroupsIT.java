package ru.levelp.at.lesson0304.unit.groups.annotated;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import ru.levelp.at.lesson0304.unit.ListManipulator;
import ru.levelp.at.lesson0304.unit.ListManipulatorImpl;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class BaseListManipulatorGroupsIT {

    protected ListManipulator manipulator;

    @BeforeAll
    void beforeAll() {
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
    void afterAll() {
        System.out.println("After All");
    }
}
