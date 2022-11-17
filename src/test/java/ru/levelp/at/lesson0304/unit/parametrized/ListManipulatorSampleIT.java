package ru.levelp.at.lesson0304.unit.parametrized;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import ru.levelp.at.lesson0304.unit.ListManipulator;
import ru.levelp.at.lesson0304.unit.ListManipulatorImpl;

class ListManipulatorSampleIT {

    @ParameterizedTest
    @NullSource
    void manipulateTest(List<String> input) {
        ListManipulator manipulator = new ListManipulatorImpl();

        assertThatThrownBy(() -> manipulator.manipulate(input, "s"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
