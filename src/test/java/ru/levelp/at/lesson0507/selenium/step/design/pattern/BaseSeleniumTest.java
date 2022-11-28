package ru.levelp.at.lesson0507.selenium.step.design.pattern;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.lesson0507.selenium.step.design.pattern.steps.ActionStep;
import ru.levelp.at.lesson0507.selenium.step.design.pattern.steps.AssertionStep;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    protected ActionStep actionStep;

    protected AssertionStep assertionStep;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        faker = new Faker();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
