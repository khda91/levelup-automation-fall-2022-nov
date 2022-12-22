package ru.levelp.at.lesson12.design.patterns.factory;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.utils.SleepUtils;

class WebDriverFactoryCliTest {

    static Stream<Arguments> browserNameDataProvider() {
        return Stream.of(
            Arguments.of("chrome"),
            Arguments.of("firefox")
        );
    }

    @ParameterizedTest
    @MethodSource("browserNameDataProvider")
    void testWithSingleton(String browserName) {
        WebDriver driver = WebDriverSingleton.get();
        driver.navigate().to("https://ya.ru");
        SleepUtils.sleep(1500);
        WebDriverSingleton.close();
    }
}
