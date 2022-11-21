package ru.levelp.at.lesson0507.selenium.basic.locators;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumXPathSelectorsLocatorsTest extends LocatorsBaseTest {

    @Test
    void idXPathSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        // DOM - > driver.findElement(By.id("text")).sendKeys("Ночь улица фонарь");
        // CSS -> driver.findElement(By.cssSelector("#text")).sendKeys("Ночь улица фонарь");
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Ночь улица фонарь");
        SleepUtils.sleep(1000);
        // DOM -> driver.findElement(By.id("text")).sendKeys(Keys.ENTER);
        // CSS -> driver.findElement(By.cssSelector("[id='text']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void nameXPathSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.xpath("//*[@name='text']"))
                .sendKeys("Я помню чудное мнговение");
        SleepUtils.sleep(1000);
        driver.findElement(By.xpath("//*[@name='text']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void classXPathSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.xpath("//*[@class='search3__input mini-suggest__input']"))
                .sendKeys("Дым табачный воздух");
        SleepUtils.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@class, 'mini-suggest__input')]")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void tagNameXPathSelector() {
        driver.navigate().to(GOOGLE_COM_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("скажи ка дядя ведь недаром");
        SleepUtils.sleep(1000);
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);

        List<WebElement> h3 = driver.findElements(By.xpath("//h3"));
        SleepUtils.sleep(1500);
        System.out.println("Amount of h3 tags on the page: " + h3.size());
        h3.forEach(elem -> System.out.println(elem.getText()));
    }

    @Test
    void combinedXPathSelector() {
        driver.navigate().to(GOOGLE_COM_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("скажи ка дядя ведь недаром");
        SleepUtils.sleep(1000);
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);
    }

    @Test
    void combinedWithParentXPathSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.xpath("//*[@name='text']")).sendKeys("скажи ка дядя ведь недаром");
        SleepUtils.sleep(1000);
        driver.findElement(By.xpath("//*[@name='text']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);

        List<WebElement> h2 = driver.findElements(By.xpath("//a//h2[contains(@class, 'OrganicTitle-LinkText')]"));
        SleepUtils.sleep(1500);
        System.out.println("Amount of h2 tags on the page: " + h2.size());
        h2.forEach(elem -> System.out.println(elem.getText()));
    }

    @Test
    void combinedParentXPathSelector() {
        driver.navigate().to(YA_RU_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.xpath("//*[@name='text']")).sendKeys("скажи ка дядя ведь недаром");
        SleepUtils.sleep(1000);
        driver.findElement(By.xpath("//*[@name='text']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);

        var text = driver.findElement(By.xpath("//div[contains(@class, 'entity-search__subtitle')]/..")).getText();
        SleepUtils.sleep(1500);
        System.out.println("Element Text: " + text);
    }

    @Test
    void linkTextXPathSelector() {
        driver.navigate().to(GOOGLE_COM_URL);
        SleepUtils.sleep(1000);

        driver.findElement(By.xpath("//*[@name='q']"))
                .sendKeys("Когда в товарищах согласья нет");
        SleepUtils.sleep(1000);
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
        SleepUtils.sleep(1000);

        driver.findElement(By.xpath("//*[contains(text(), 'Лебедь, Щука и Рак (Крылов)')]")).click();
        SleepUtils.sleep(1500);
    }
}
