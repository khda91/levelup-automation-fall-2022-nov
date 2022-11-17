package ru.levelp.at.lesson0304.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JunitStandardAssertionIT {

    @Test
    void sample() {
        Assertions.assertEquals(4, 2 + 2);
    }
}
