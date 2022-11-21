package ru.levelp.at.lesson0507.selenium.basic.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

class FrameExampleTest {

    private WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://mail.ru");
    }

    @Test
    void example() {
        SleepUtils.sleep(1000);

        driver.findElement(By.cssSelector("[data-testid='enter-mail-primary']")).click();

        SleepUtils.sleep(2000);

        WebElement frame = driver.findElement(By.cssSelector("iframe.ag-popup__frame__layout__iframe"));
        WebDriver frameDriver = driver.switchTo().frame(frame);

        frameDriver.findElement(By.cssSelector("[name='username']")).sendKeys("test_email");

        SleepUtils.sleep(2000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
