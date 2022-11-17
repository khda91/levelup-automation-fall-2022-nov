package ru.levelp.at.lesson0304.unit.parametrized;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelp.at.lesson0304.unit.ListManipulator;
import ru.levelp.at.lesson0304.unit.ListManipulatorImpl;

class ListManipulatorMethodSourceIT {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
            Arguments.of(List.of("ssss", "null"), "s", List.of("", "null")),
            Arguments.of(Collections.emptyList(), "s", Collections.emptyList())
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void manipulateTest(List<String> input, String letter, List<String> expected) {
        ListManipulator manipulator = new ListManipulatorImpl();
        List<String> actual = manipulator.manipulate(input, letter);

        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson0304.unit.parametrized.ListManipulatorMethodSourceIT#dataProvider")
    void manipulateExternalDataProviderTest(List<String> input, String letter, List<String> expected) {
        ListManipulator manipulator = new ListManipulatorImpl();
        List<String> actual = manipulator.manipulate(input, letter);

        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
