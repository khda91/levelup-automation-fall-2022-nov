package ru.levelp.at.lesson0507.selenium.basic.locators;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumDomLocatorsTest extends LocatorsBaseTest {

    @Test
    void idDomSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.id("text")).sendKeys("Ночь улица фонарь");
        SleepUtils.sleep(1000);
        driver.findElement(By.id("text")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void nameDomSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.name("text")).sendKeys("Я помню чудное мнговение");
        SleepUtils.sleep(1000);
        driver.findElement(By.name("text")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void classDomSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.className("search3__input")).sendKeys("Дым табычный воздух");
        SleepUtils.sleep(1000);
        driver.findElement(By.className("mini-suggest__input")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void linkTextDomSelector() {
        driver.navigate().to(GOOGLE_COM_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.name("q")).sendKeys("Когда в товарищах согласья нет");
        SleepUtils.sleep(1000);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);

        driver.findElement(By.linkText("Лебедь, Щука и Рак (Крылов) - Викитека")).click();
        SleepUtils.sleep(1500);
    }

    @Test
    void partialLinkTextDomSelector() {
        driver.navigate().to(GOOGLE_COM_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.name("q")).sendKeys("Когда в товарищах согласья нет");
        SleepUtils.sleep(1000);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);

        driver.findElement(By.partialLinkText("Лебедь, Щука и Рак")).click();
        SleepUtils.sleep(1500);
    }

    @Test
    void tagNameDomSelector() {
        driver.navigate().to(GOOGLE_COM_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.name("q")).sendKeys("скажи ка дядя ведь недаром");
        SleepUtils.sleep(1000);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);

        List<WebElement> h3 = driver.findElements(By.tagName("h3"));
        SleepUtils.sleep(1500);
        System.out.println("Amount of h3 tags on the page: " + h3.size());
        h3.forEach(elem -> System.out.println(elem.getText()));
    }
}
