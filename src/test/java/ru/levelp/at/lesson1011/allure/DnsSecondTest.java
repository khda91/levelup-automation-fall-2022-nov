package ru.levelp.at.lesson1011.allure;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelp.at.utils.SleepUtils;

@DisplayName("DNS - машазин тест на сравнение Second")
@Owner("Василий Пупкин")
@Epic("Compare Epic")
@Feature("Compare Feature 1")
class DnsSecondTest extends BaseSeleniumTest {

    @Test
    @DisplayName("Сравнение товаров Second")
    @Description("Тест проверяет, что выбранные товары отображаются на странице сравнения")
    @TmsLink("ABC-123")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Compare Test 1")
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

    @Test
    @DisplayName("Сравнение товаров Second")
    @Description("Тест проверяет, что выбранные товары отображаются на странице сравнения")
    @TmsLink("ABC-124")
    @Issue("ABC-321")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Negative compare test")
    void failCompareTest() {

        // Открыть главную страницу DNS
        actionStep.openMainDnsPage();

        // октрытие нужной категории товаров
        actionStep.openProductCategory("Смартфоны и фототехника", "Смартфоны и гаджеты", "Смартфоны");

        Assertions.fail("Тестовое падение класса");

        // Сравнить выбранные товары
        var addedToCompareProductsTitles =  actionStep.compareSelectedProducts(1, 2, 3);

        // Проверить что выбранные товары добылены в список
        assertionStep.selectedProductsShouldBeDisplayedOnComparePage(addedToCompareProductsTitles);

        SleepUtils.sleep(3000);
    }
}
