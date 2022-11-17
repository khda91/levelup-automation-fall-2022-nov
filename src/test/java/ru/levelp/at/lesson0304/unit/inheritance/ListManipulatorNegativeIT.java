package ru.levelp.at.lesson0304.unit.inheritance;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListManipulatorNegativeIT extends BaseListManipulatorIT {

    @Test
    void manipulateLetterNullTest() {
        System.out.println("manipulateLetterNullTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");

        Assertions.assertThatThrownBy(() -> manipulator.manipulate(input, null))
                  .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void manipulateLetterNullWithMessageTest() {
        System.out.println("manipulateLetterNullWithMessageTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");

        Assertions.assertThatThrownBy(() -> manipulator.manipulate(input, null))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("Буква не может быть null.");
    }

    @Test
    void manipulateListNullStandardJunitAssertTest() {
        System.out.println("manipulateListNullStandardJunitAssertTest");
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> manipulator.manipulate(null, "s"));
    }
}
