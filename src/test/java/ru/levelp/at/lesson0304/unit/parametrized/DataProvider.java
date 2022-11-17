package ru.levelp.at.lesson0304.unit.parametrized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class DataProvider {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
            Arguments.of(new ArrayList<String>() {
                {
                    add("ssssss");
                    add(null);
                    add("null");
                }
            }, "s", List.of("", "null")),
            Arguments.of(Collections.emptyList(), "s", Collections.emptyList())
        );
    }
}
