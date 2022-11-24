package ru.levelp.at.lesson0507.selenium.basic.wait;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ExplicitWaitTest extends WaitBaseTest {

    private WebDriverWait wait;

    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    }

    @Test
    void explicitWait() {
        long start = System.currentTimeMillis();
        try {
            driver.navigate().to(GOOGLE_COM_URL);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q']")))
                .sendKeys("Когда в товарищах согласья нет");
            var queryTextBox = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q']")));
            queryTextBox.sendKeys(Keys.ENTER);

            List<WebElement> searchResults = wait
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a/h3"), 3));

            wait.until(ExpectedConditions.elementToBeClickable(searchResults.get(0))).click();

            String text = wait.until(ExpectedConditions
                                  .visibilityOfElementLocated(By.xpath("//*[@id='firstHeading']/span")))
                              .getText();
            assertThat(text).isEqualTo("Лебедь, Щука и Рак (Крылов)");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Execution time of sleepWait is " + (end - start));
        }
    }

    @Test
    void explicitWaitElementNotFound() {
        long start = System.currentTimeMillis();
        try {
            driver.navigate().to(GOOGLE_COM_URL);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q']")))
                .sendKeys("Когда в товарищах согласья нет");
            var queryTextBox = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q']")));
            queryTextBox.sendKeys(Keys.ENTER);

            List<WebElement> searchResults = wait
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a/h3"), 3));

            wait.until(ExpectedConditions.elementToBeClickable(searchResults.get(0))).click();

            String text = wait.until(ExpectedConditions
                                  .visibilityOfElementLocated(By.xpath("//*[@id='firstHeading1']/span")))
                              .getText();
            assertThat(text).isEqualTo("Лебедь, Щука и Рак (Крылов)");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Execution time of sleepWait is " + (end - start));
        }
    }
}
