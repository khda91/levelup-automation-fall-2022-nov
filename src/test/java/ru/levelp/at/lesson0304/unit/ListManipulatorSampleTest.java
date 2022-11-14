package ru.levelp.at.lesson0304.unit;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ListManipulatorSampleTest {

    @Test
    // shouldReturnListOfStringsWithoutDefinedLetterTest()
    public void manipulateTest() {
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "am", "cloe", "rock");
        ListManipulator manipulator = new ListManipulator();
        List<String> actual = manipulator.manipulate(input, "s");

        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void manipulateOneMoreTest() {
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");
        List<String> expected = List.of("end", "aM", "cloe", "rOck", "lk");
        ListManipulator manipulator = new ListManipulator();
        List<String> actual = manipulator.manipulate(input, "s");

        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void manipulateWithoutAssertionTest() {
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "am", "close", "rock");
        ListManipulator manipulator = new ListManipulator();
        List<String> actual = manipulator.manipulate(input, "s");

        // Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
