package ru.levelp.at.lesson0507.step.design.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelp.at.lesson0507.step.design.pattern.composite.DnsProductCardComposite;

public class DnsProductsCatalogPage extends DnsBasePage {

    @FindBy(css = "[data-id='product']")
    private List<WebElement> products;

    public DnsProductsCatalogPage(WebDriver driver) {
        super(driver);
    }

    public List<DnsProductCardComposite> getProducts() {
        List<DnsProductCardComposite> list = new ArrayList<>();
        for (WebElement product : products) {
            list.add(new DnsProductCardComposite(driver, product));
        }
        return list;
    }

    public List<DnsProductCardComposite> getProductsWithStreamApi() {
        return products.stream()
                       .map(item -> new DnsProductCardComposite(driver, item))
                       .collect(Collectors.toList());
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
