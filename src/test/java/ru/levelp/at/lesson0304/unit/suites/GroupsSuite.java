package ru.levelp.at.lesson0304.unit.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import ru.levelp.at.lesson0304.unit.inheritance.ListManipulatorNegativeIT;

@Suite
@SelectClasses({ListManipulatorNegativeIT.class})
public class GroupsSuite {
}
