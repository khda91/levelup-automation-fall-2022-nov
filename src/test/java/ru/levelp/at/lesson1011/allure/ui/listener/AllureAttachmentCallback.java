package ru.levelp.at.lesson1011.allure.ui.listener;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson1011.allure.ui.context.TestContext;

public class AllureAttachmentCallback implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) {
        System.out.println("after Test Execution");
        var driver = (WebDriver) TestContext.getInstance().getObject("driver");
        attachScreenshot(driver);
        attachPageSource(driver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachScreenshot(final WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private void attachPageSource(final WebDriver driver) {
        Allure.addAttachment("page_source_code", "text/html", driver.getPageSource(), ".html");
    }
}
