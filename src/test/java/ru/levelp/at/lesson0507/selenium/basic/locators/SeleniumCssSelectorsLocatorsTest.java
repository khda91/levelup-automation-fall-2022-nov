package ru.levelp.at.lesson0507.selenium.basic.locators;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumCssSelectorsLocatorsTest extends LocatorsBaseTest {

    @Test
    void idCssSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        // DOM - > driver.findElement(By.id("text")).sendKeys("Ночь улица фонарь");
        driver.findElement(By.cssSelector("#text")).sendKeys("Ночь улица фонарь");
        SleepUtils.sleep(1000);
        // DOM -> driver.findElement(By.id("text")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("[id='text']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void nameCssSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.cssSelector("[name='text']")).sendKeys("Я помню чудное мнговение");
        SleepUtils.sleep(1000);
        driver.findElement(By.cssSelector("[name='text']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void classCssSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.cssSelector(".search3__input")).sendKeys("Дым табычный воздух");
        SleepUtils.sleep(1000);
        driver.findElement(By.cssSelector("[class='search3__input mini-suggest__input']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void tagNameCssSelector() {
        driver.navigate().to(GOOGLE_COM_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.name("q")).sendKeys("скажи ка дядя ведь недаром");
        SleepUtils.sleep(1000);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);

        List<WebElement> h3 = driver.findElements(By.cssSelector("h3"));
        SleepUtils.sleep(1500);
        System.out.println("Amount of h3 tags on the page: " + h3.size());
        h3.forEach(elem -> System.out.println(elem.getText()));
    }

    @Test
    void combinedCssSelector() {
        driver.navigate().to(GOOGLE_COM_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.cssSelector("input[name='q']")).sendKeys("скажи ка дядя ведь недаром");
        SleepUtils.sleep(1000);
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void combinedWithParentCssSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.cssSelector("[name='text']")).sendKeys("скажи ка дядя ведь недаром");
        SleepUtils.sleep(1000);
        driver.findElement(By.cssSelector("[name='text']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);

        List<WebElement> h2 = driver.findElements(By.cssSelector("a h2.OrganicTitle-LinkText"));
        SleepUtils.sleep(1500);
        System.out.println("Amount of h2 tags on the page: " + h2.size());
        h2.forEach(elem -> System.out.println(elem.getText()));
    }
}
