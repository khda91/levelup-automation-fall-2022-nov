package ru.levelp.at.lesson0507.selenium.step.design.pattern;

import org.junit.jupiter.api.Test;
import ru.levelp.at.utils.SleepUtils;

class DnsTest extends BaseSeleniumTest {

    @Test
    void compareTest() {

        // Открыть главную страницу DNS
        actionStep.openMainDnsPage();

        // октрытие нужной категории товаров
        actionStep.openProductCategory("Смартфоны и фототехника", "Смартфоны и гаджеты", "Смартфоны");

        // Сравнить выбранные товары
        var addedToCompareProductsTitles =  actionStep.compareSelectedProducts(1, 2, 3);

        // Проверить что выбранные товары добылены в список
        assertionStep.selectedProductsShouldBeDisplayedOnComparePage(addedToCompareProductsTitles);

        SleepUtils.sleep(3000);
    }
}
