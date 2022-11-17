package ru.levelp.at.lesson0304.unit.groups.annotated;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.unit.groups.annotated.annotations.NegativeGroup;
import ru.levelp.at.lesson0304.unit.groups.annotated.annotations.OneMoreGroup;
import ru.levelp.at.lesson0304.unit.groups.annotated.annotations.PositiveGroup;

class ListManipulatorNegativeIT extends BaseListManipulatorGroupsIT {

    @Test
    @PositiveGroup
    void manipulateOneMoreTest() {
        System.out.println("manipulateOneMoreTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");
        List<String> expected = List.of("end", "aM", "cloe", "rOck", "lk");
        List<String> actual = manipulator.manipulate(input, "s");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    @PositiveGroup
    @OneMoreGroup
    void manipulateWithoutAssertionTest() {
        System.out.println("manipulateWithoutAssertionTest");
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "am", "close", "rock");
        List<String> actual = manipulator.manipulate(input, "s");

        // Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    @NegativeGroup
    void manipulateLetterNullWithMessageTest() {
        System.out.println("manipulateLetterNullWithMessageTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");

        Assertions.assertThatThrownBy(() -> manipulator.manipulate(input, null))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("Буква не может быть null.");
    }

    @Test
    @NegativeGroup
    void manipulateListNullStandardJunitAssertTest() {
        System.out.println("manipulateListNullStandardJunitAssertTest");
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> manipulator.manipulate(null, "s"));
    }
}
