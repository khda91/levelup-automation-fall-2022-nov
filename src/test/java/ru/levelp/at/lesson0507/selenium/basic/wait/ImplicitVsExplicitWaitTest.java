package ru.levelp.at.lesson0507.selenium.basic.wait;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ImplicitVsExplicitWaitTest extends WaitBaseTest {

    private static final String OZON_URL = "https://www.ozon.ru/category/smartfony-15502/";

    @Test
    void elementDisappearTest() {
        long start = System.currentTimeMillis();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
            driver.navigate().to(OZON_URL);

            driver.findElement(By.cssSelector("div.ks5 div.sk7 div.ks8 button > span._4-a6")).click();
            driver.findElement(By.xpath("//*[text()='Добавить в сравнение']")).click();

            driver.findElement(By.cssSelector("div._42-a9 > div._29-a > div._29-a8 > button")).click();

            WebElement dialog = driver.findElement(By.cssSelector("div._42-a9"));
            assertThat(dialog.isDisplayed()).isFalse();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("element disappear test duration -> " + (end - start));
        }
    }

    @Test
    void implicitMoreThenExplicit() {
        long start = System.currentTimeMillis();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
            var wait = new WebDriverWait(driver, Duration.ofMillis(5000));

            driver.navigate().to(GOOGLE_COM_URL);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q1']")))
                .sendKeys("Когда в товарищах согласья нет");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Execution time of implicitMoreThenExplicit is " + (end - start));
        }
    }

    @Test
    void implicitLessThenExplicit() {
        long start = System.currentTimeMillis();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
            var wait = new WebDriverWait(driver, Duration.ofMillis(11000));

            driver.navigate().to(GOOGLE_COM_URL);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q1']")))
                .sendKeys("Когда в товарищах согласья нет");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Execution time of implicitLessThenExplicit is " + (end - start));
        }
    }

    @Test
    void implicitAndExplicitTogether() {
        long start = System.currentTimeMillis();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
            var wait = new WebDriverWait(driver, Duration.ofMillis(11000));

            driver.navigate().to(GOOGLE_COM_URL);

            driver.findElement(By.xpath("//*[@name='q']"))
                  .sendKeys("Когда в товарищах согласья нет");

            var implicitWaitTime = driver.manage().timeouts().getImplicitWaitTimeout();
            driver.manage().timeouts().implicitlyWait(Duration.ZERO);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q1']")))
                .sendKeys(Keys.ENTER);

            driver.manage().timeouts().implicitlyWait(implicitWaitTime);
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Execution time of implicitLessThenExplicit is " + (end - start));
        }
    }
}
