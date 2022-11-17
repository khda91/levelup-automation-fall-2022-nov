package ru.levelp.at.lesson0304.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ListManipulatorSampleFailIT {

    @Test
    void manipulateTest() {
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "cloe", "Sam", "rock");

        ListManipulator manipulator = new ListManipulatorImpl();
        List<String> actual = manipulator.manipulate(input, "s");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
