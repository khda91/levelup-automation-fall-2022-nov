package ru.levelp.at.lesson0304.unit.groups.annotated;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.unit.groups.annotated.annotations.NegativeGroup;
import ru.levelp.at.lesson0304.unit.groups.annotated.annotations.OneMoreGroup;
import ru.levelp.at.lesson0304.unit.groups.annotated.annotations.PositiveGroup;

class ListManipulatorPositiveIT extends BaseListManipulatorGroupsIT {

    @Test
    @PositiveGroup
    void manipulateTest() {
        System.out.println("manipulateTest");
        List<String> input = List.of("send", "close", "Sam", "rock");
        List<String> expected = List.of("end", "cloe", "am", "rock");
        List<String> actual = manipulator.manipulate(input, "s");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    @NegativeGroup
    @OneMoreGroup
    void manipulateLetterNullTest() {
        System.out.println("manipulateLetterNullTest");
        List<String> input = List.of("Send", "close", "SaM", "rOck", "SssSSlkSSsss");

        Assertions.assertThatThrownBy(() -> manipulator.manipulate(input, null))
                  .isInstanceOf(IllegalArgumentException.class);
    }
}
