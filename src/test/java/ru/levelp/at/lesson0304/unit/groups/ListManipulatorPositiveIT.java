package ru.levelp.at.lesson0304.unit.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.levelp.at.lesson0304.unit.groups.TestGroupName.NEGATIVE_GROUP;
import static ru.levelp.at.lesson0304.unit.groups.TestGroupName.ONE_MORE_GROUP;
import static ru.levelp.at.lesson0304.unit.groups.TestGroupName.POSITIVE_GROUP;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ListManipulatorPositiveIT extends BaseListManipulatorGroupsIT {

    @Test
    @Tag(POSITIVE_GROUP)
    void manipulateTest() {
        System.out.println("manipulateTest");
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "cloe", "am", "rock");
        List<String> actual = manipulator.manipulate(input, "s");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    @Tag(NEGATIVE_GROUP)
    @Tag(ONE_MORE_GROUP)
    void manipulateLetterNullTest() {
        System.out.println("manipulateLetterNullTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");

        Assertions.assertThatThrownBy(() -> manipulator.manipulate(input, null))
                  .isInstanceOf(IllegalArgumentException.class);
    }
}
