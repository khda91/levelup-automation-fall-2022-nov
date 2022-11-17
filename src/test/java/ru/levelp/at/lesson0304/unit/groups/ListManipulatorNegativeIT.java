package ru.levelp.at.lesson0304.unit.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.levelp.at.lesson0304.unit.groups.TestGroupName.NEGATIVE_GROUP;
import static ru.levelp.at.lesson0304.unit.groups.TestGroupName.ONE_MORE_GROUP;
import static ru.levelp.at.lesson0304.unit.groups.TestGroupName.POSITIVE_GROUP;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

class ListManipulatorNegativeIT extends BaseListManipulatorGroupsIT {

    @Test
    @Tag(POSITIVE_GROUP)
    void manipulateOneMoreTest() {
        System.out.println("manipulateOneMoreTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");
        List<String> expected = List.of("end", "aM", "cloe", "rOck", "lk");
        List<String> actual = manipulator.manipulate(input, "s");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    @Tags({@Tag(POSITIVE_GROUP), @Tag(ONE_MORE_GROUP)})
    void manipulateWithoutAssertionTest() {
        System.out.println("manipulateWithoutAssertionTest");
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "am", "close", "rock");
        List<String> actual = manipulator.manipulate(input, "s");

        // Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    @Tag(NEGATIVE_GROUP)
    void manipulateLetterNullWithMessageTest() {
        System.out.println("manipulateLetterNullWithMessageTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");

        Assertions.assertThatThrownBy(() -> manipulator.manipulate(input, null))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("Буква не может быть null.");
    }

    @Test
    @Tag(NEGATIVE_GROUP)
    void manipulateListNullStandardJunitAssertTest() {
        System.out.println("manipulateListNullStandardJunitAssertTest");
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> manipulator.manipulate(null, "s"));
    }
}
