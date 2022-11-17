package ru.levelp.at.lesson0304.unit.transitive.dependencies;

import static org.assertj.core.api.Assertions.assertThat;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class SelenideExample {

    @Test
    public void mvnRepositoryTest() {
        Selenide.open("https://mvnrepository.com/");
        Selenide.$("#query").sendKeys("selenium");
        Selenide.$("[value='Search']").click();
        String text = Selenide.$(".content > div.im h2.im-title").getText();
        assertThat(text).contains("1. Selenium Java");
    }
}
