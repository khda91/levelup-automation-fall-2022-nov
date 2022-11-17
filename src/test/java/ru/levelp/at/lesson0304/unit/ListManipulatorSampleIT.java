package ru.levelp.at.lesson0304.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ListManipulatorSampleIT {

    @Test
    void manipulateTest() {
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "cloe", "am", "rock");

        ListManipulator manipulator = new ListManipulatorImpl();
        List<String> actual = manipulator.manipulate(input, "s");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void manipulateOneMoreTest() {
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");
        List<String> expected = List.of("end", "aM", "cloe", "rOck", "lk");
        ListManipulator manipulator = new ListManipulatorImpl();
        List<String> actual = manipulator.manipulate(input, "s");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void manipulateWithoutAssertionTest() {
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "am", "close", "rock");
        ListManipulator manipulator = new ListManipulatorImpl();
        List<String> actual = manipulator.manipulate(input, "s");

        // Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
