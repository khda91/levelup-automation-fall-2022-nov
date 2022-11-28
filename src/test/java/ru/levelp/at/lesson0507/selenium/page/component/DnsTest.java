package ru.levelp.at.lesson0507.selenium.page.component;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0507.page.component.DnsCatalogPage;
import ru.levelp.at.lesson0507.page.component.DnsComparePage;
import ru.levelp.at.lesson0507.page.component.DnsIndexPage;
import ru.levelp.at.lesson0507.page.component.DnsProductsCatalogPage;
import ru.levelp.at.lesson0507.page.component.DnsSubCatalogPage;
import ru.levelp.at.lesson0507.page.component.composite.DnsProductCardComposite;
import ru.levelp.at.utils.SleepUtils;

class DnsTest extends BaseSeleniumTest {

    @Test
    void compareTest() {
        var indexPage = new DnsIndexPage(driver);
        indexPage.open();

        indexPage.openMenuCategory("Смартфоны и фототехника");

        var catalogPage = new DnsCatalogPage(driver);
        catalogPage.getSubcategoryItems().openSubcategory("Смартфоны и гаджеты");

        var subCatalogPage = new DnsSubCatalogPage(driver);
        subCatalogPage.getSubcategoryItems().openSubcategory("Смартфоны");

        List<String> addedToCompareProductsTitles = new ArrayList<>();

        var productsPage = new DnsProductsCatalogPage(driver);
        List<DnsProductCardComposite> products = productsPage.getProducts();
        products.get(0).clickAddToCompare();
        addedToCompareProductsTitles.add(products.get(0).getTitle());

        SleepUtils.sleep(5000);

        products.get(1).clickAddToCompare();
        addedToCompareProductsTitles.add(products.get(1).getTitle());

        productsPage.clickToCompareButton();

        var comparePage = new DnsComparePage(driver);
        List<String> productTitles = comparePage.getProductTitles();

        assertThat(productTitles).containsExactlyInAnyOrderElementsOf(addedToCompareProductsTitles);

        SleepUtils.sleep(3000);
    }
}
