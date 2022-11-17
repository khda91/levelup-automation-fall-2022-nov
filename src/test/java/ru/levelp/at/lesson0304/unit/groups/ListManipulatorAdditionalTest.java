package ru.levelp.at.lesson0304.unit.groups;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ListManipulatorAdditionalTest extends BaseListManipulatorTest {

    @Test(groups = {"positive"})
    public void manipulateTest() {
        System.out.println("manipulateTest");
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "am", "cloe", "rock");
        List<String> actual = manipulator.manipulate(input, "s");

        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test(groups = {"negative"})
    public void manipulateLetterNullWithMessageTest() {
        System.out.println("manipulateLetterNullWithMessageTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");

        Assertions.assertThatThrownBy(() -> manipulator.manipulate(input, null))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("Буква не может быть null.");
    }

    @Test(groups = {"negative"})
    public void manipulateWithEmptyList() {
        System.out.println("manipulateLetterNullWithMessageTest");
        List<String> actual = manipulator.manipulate(Collections.emptyList(), "s");

        Assertions.assertThat(actual).isEmpty();
    }
}
