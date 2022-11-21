package ru.levelp.at.lesson0507.selenium.basic.sample;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.levelp.at.utils.SleepUtils;

public class BrowsersSampleTest {

    @Nested
    class ChromeTest {
        private WebDriver driver;

        @BeforeEach
        void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            SleepUtils.sleep(1500);
        }

        @Test
        void openGoogleHomePage() {
            driver.navigate().to("https://www.google.com/");
            SleepUtils.sleep(1500);
            var actualTitle = driver.getTitle();

            assertThat(actualTitle).isEqualTo("Google");
        }

        @AfterEach
        void tearDown() {
            driver.quit();
            SleepUtils.sleep(1500);
        }
    }

    @Nested
    class FirefoxTest {
        private WebDriver driver;

        @BeforeEach
        void setUp() {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            SleepUtils.sleep(1500);
        }

        @Test
        void openGoogleHomePage() {
            driver.navigate().to("https://www.google.com/");
            SleepUtils.sleep(1500);
            var actualTitle = driver.getTitle();

            assertThat(actualTitle).isEqualTo("Google");
        }

        @AfterEach
        void tearDown() {
            driver.quit();
            SleepUtils.sleep(1500);
        }
    }

    @Nested
    class EdgeTest {
        private WebDriver driver;

        @BeforeEach
        void setUp() {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            SleepUtils.sleep(1500);
        }

        @Test
        void openGoogleHomePage() {
            driver.navigate().to("https://www.google.com/");
            SleepUtils.sleep(1500);
            var actualTitle = driver.getTitle();

            assertThat(actualTitle).isEqualTo("Google");
        }

        @AfterEach
        void tearDown() {
            driver.quit();
            SleepUtils.sleep(1500);
        }
    }
}
