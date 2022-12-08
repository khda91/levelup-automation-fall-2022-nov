package ru.levelp.at.lesson1011.allure;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson1011.allure.composite.DnsSubcategoryItemComposite;

public class DnsCatalogPage extends DnsBasePage {

    private final DnsSubcategoryItemComposite subcategoryItems;

    public DnsCatalogPage(WebDriver driver) {
        super(driver);
        subcategoryItems = new DnsSubcategoryItemComposite(driver);
    }

    public DnsSubcategoryItemComposite getSubcategoryItems() {
        return subcategoryItems;
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
