package ru.levelp.at.lesson0507.selenium.basic.wait;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

class ImplicitWaitTest extends WaitBaseTest {

    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
    }

    @Test
    void implicitWait() {
        long start = System.currentTimeMillis();
        try {
            driver.navigate().to(GOOGLE_COM_URL);

            driver.findElement(By.xpath("//*[@name='q']"))
                  .sendKeys("Когда в товарищах согласья нет");
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//*[contains(text(), 'Лебедь, Щука и Рак (Крылов)')]")).click();

            String text = driver.findElement(By.xpath("//*[@id='firstHeading']/span")).getText();
            assertThat(text).isEqualTo("Лебедь, Щука и Рак (Крылов)");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Execution time of sleepWait is " + (end - start));
        }
    }

    @Test
    void implicitWaitElementNotFound() {
        long start = System.currentTimeMillis();
        try {
            driver.navigate().to(GOOGLE_COM_URL);

            driver.findElement(By.xpath("//*[@name='q']"))
                  .sendKeys("Когда в товарищах согласья нет");
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//*[contains(text(), 'Лебедь, Щука и Рак (Крылов)')]")).click();

            String text = driver.findElement(By.xpath("//*[@id='firstHeading1']/span")).getText();
            assertThat(text).isEqualTo("Лебедь, Щука и Рак (Крылов)");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Execution time of sleepWait is " + (end - start));
        }
    }
}
