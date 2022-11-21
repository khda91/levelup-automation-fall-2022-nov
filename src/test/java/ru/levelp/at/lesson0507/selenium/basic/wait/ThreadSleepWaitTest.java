package ru.levelp.at.lesson0507.selenium.basic.wait;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.levelp.at.utils.SleepUtils;

class ThreadSleepWaitTest extends WaitBaseTest {

    @Test
    void sleepWait() {
        long start = System.currentTimeMillis();
        try {
            driver.navigate().to(GOOGLE_COM_URL);
            SleepUtils.sleep(1000);

            driver.findElement(By.xpath("//*[@name='q']"))
                  .sendKeys("Когда в товарищах согласья нет");
            SleepUtils.sleep(1000);
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
            SleepUtils.sleep(5000);

            driver.findElement(By.xpath("//*[contains(text(), 'Лебедь, Щука и Рак (Крылов)')]")).click();
            SleepUtils.sleep(1500);

            String text = driver.findElement(By.xpath("//*[@id='firstHeading']/span")).getText();
            assertThat(text).isEqualTo("Лебедь, Щука и Рак (Крылов)");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Execution time of sleepWait is " + (end - start));
        }
    }
}
