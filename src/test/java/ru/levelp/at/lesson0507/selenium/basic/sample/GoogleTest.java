package ru.levelp.at.lesson0507.selenium.basic.sample;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

class GoogleTest {

    private WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        SleepUtils.sleep(2500);
    }

    @Test
    void openGoogleHomePage() {
        driver.navigate().to("https://www.google.com/");
        SleepUtils.sleep(2500);
        var actualTitle = driver.getTitle();

        assertThat(actualTitle).isEqualTo("Google");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        SleepUtils.sleep(1500);
    }
}
