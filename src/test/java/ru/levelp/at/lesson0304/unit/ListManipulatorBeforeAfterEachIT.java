package ru.levelp.at.lesson0304.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListManipulatorBeforeAfterEachIT {

    private ListManipulator manipulator;

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
        manipulator = new ListManipulatorImpl();
    }

    @Test
    void manipulateTest() {
        System.out.println("manipulateTest");
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "cloe", "am", "rock");
        List<String> actual = manipulator.manipulate(input, "s");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void manipulateOneMoreTest() {
        System.out.println("manipulateOneMoreTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");
        List<String> expected = List.of("end", "aM", "cloe", "rOck", "lk");
        List<String> actual = manipulator.manipulate(input, "s");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void manipulateWithoutAssertionTest() {
        System.out.println("manipulateWithoutAssertionTest");
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "am", "close", "rock");
        List<String> actual = manipulator.manipulate(input, "s");

        // Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
        manipulator = null;
    }

}
