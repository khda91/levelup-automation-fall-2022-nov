package ru.levelp.at.lesson0507.selenium.basic.handles;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

class DriverWindowHandleTest {

    private WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void handles() {
        System.out.println("Open google.com");
        driver.navigate().to("https://google.com");
        System.out.println(driver.getWindowHandles());
        System.out.println();

        SleepUtils.sleep(1000);

        System.out.println("Open ya.ru");
        driver = driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://ya.ru");
        System.out.println(driver.getWindowHandles());
        System.out.println();

        SleepUtils.sleep(1000);

        System.out.println("Open mvnrepository.com");
        driver = driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://mvnrepository.com/");
        System.out.println(driver.getWindowHandles());

        SleepUtils.sleep(1000);

        System.out.println();
        System.out.println("------------------");
        System.out.println();

        System.out.println("Close ya.ru");
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver = driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().contains("ya.ru")) {
                driver.close();
            }
        }
        System.out.println(driver.getWindowHandles());
        System.out.println();

        SleepUtils.sleep(1000);

        driver.quit();

        SleepUtils.sleep(1000);
    }
}
